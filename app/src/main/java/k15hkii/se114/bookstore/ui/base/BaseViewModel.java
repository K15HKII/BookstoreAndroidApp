package k15hkii.se114.bookstore.ui.base;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;
import androidx.lifecycle.ViewModel;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Getter;

import javax.inject.Inject;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseViewModel<N extends INavigator> extends ViewModel implements Observable {

    @Inject
    @Getter
    SchedulerProvider schedulerProvider;

    private final AtomicInteger mPendingTask = new AtomicInteger(0);

    public synchronized void increasePendingTask() {
        if (mPendingTask.incrementAndGet() == 1) {
            notifyPropertyChanged(BR.loading);
        }
    }

    public synchronized void decreasePendingTask() {
        if (mPendingTask.decrementAndGet() < 1) {
            notifyPropertyChanged(BR.loading);
        }
    }

    @Bindable
    public boolean isLoading() {
        return mPendingTask.get() > 0;
    }

    public BaseViewModel(SchedulerProvider schedulerProvider) {
        this.schedulerProvider = schedulerProvider;
    }

    @Getter
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    private WeakReference<N> navigator = new WeakReference<>(null);

    public N getNavigator() {
        return navigator.get();
    }

    public void initializeFromBundle(@NonNull Bundle bundle) {

    }

    public void setNavigator(N navigator) {
        this.navigator = new WeakReference<>(navigator);
    }

    @Override
    protected void onCleared() {
        compositeDisposable.dispose();
        super.onCleared();
    }

    private final PropertyChangeRegistry callbacks = new PropertyChangeRegistry();

    protected <T> void dispose(Single<T> single, Consumer<? super T> onSuccess, Consumer<? super Throwable> onError) {
        compositeDisposable.add(single
                .doOnError(throwable -> {
                    Log.d(getClass().getSimpleName(), "dispose: " + throwable.getMessage(), throwable);
                })
                .doOnSubscribe(disposable -> {
                    increasePendingTask();
                })
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doFinally(this::decreasePendingTask)
                .subscribe(onSuccess, onError));
    }

    protected <T> void dispose(Single<T> single) {
        dispose(single, res -> {
        }, throwable -> {
        });
    }

    @Override
    public void addOnPropertyChangedCallback(
            Observable.OnPropertyChangedCallback callback) {
        callbacks.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(
            Observable.OnPropertyChangedCallback callback) {
        callbacks.remove(callback);
    }

    protected void notifyChange() {
        callbacks.notifyCallbacks(this, 0, null);
    }

    protected void notifyPropertyChanged(int fieldId) {
        callbacks.notifyCallbacks(this, fieldId, null);
    }

}
