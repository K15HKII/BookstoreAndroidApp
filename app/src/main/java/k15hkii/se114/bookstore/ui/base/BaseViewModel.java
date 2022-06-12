package k15hkii.se114.bookstore.ui.base;

import android.os.Bundle;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.PropertyChangeRegistry;
import androidx.lifecycle.ViewModel;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Getter;

import javax.inject.Inject;
import java.lang.ref.WeakReference;

public abstract class BaseViewModel<N extends INavigator> extends ViewModel implements Observable {

    private final ObservableBoolean isLoading = new ObservableBoolean();

    @Inject
    @Getter
    SchedulerProvider schedulerProvider;

    public BaseViewModel(SchedulerProvider schedulerProvider) {
        this.schedulerProvider = schedulerProvider;
    }

    @Getter
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

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

    public ObservableBoolean getIsLoading() {
        return isLoading;
    }

    public void setIsLoading(boolean isLoading) {
        this.isLoading.set(isLoading);
    }

    private PropertyChangeRegistry callbacks = new PropertyChangeRegistry();

    protected <T> void dispose(Single<T> single, Consumer<? super T> onSuccess, Consumer<? super Throwable> onError) {
        compositeDisposable.add(single
                .doOnError(throwable -> {
                    Log.d(getClass().getSimpleName(), "dispose: " + throwable.getMessage(), throwable);
                })
                .doOnSubscribe(disposable -> isLoading.set(true))
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doFinally(() -> isLoading.set(false))
                .subscribe(onSuccess, onError));
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
