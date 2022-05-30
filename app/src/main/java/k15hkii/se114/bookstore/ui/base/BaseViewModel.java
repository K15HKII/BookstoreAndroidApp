package k15hkii.se114.bookstore.ui.base;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Getter;

import javax.inject.Inject;
import java.lang.ref.WeakReference;

public abstract class BaseViewModel<N extends INavigator> extends ViewModel {

    private final ObservableBoolean isLoading = new ObservableBoolean();

    @Inject @Getter SchedulerProvider schedulerProvider;

    public BaseViewModel(SchedulerProvider schedulerProvider) {
        this.schedulerProvider = schedulerProvider;
    }

    @Getter private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private WeakReference<N> navigator = new WeakReference<>(null);

    public N getNavigator() {
        return navigator.get();
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

}
