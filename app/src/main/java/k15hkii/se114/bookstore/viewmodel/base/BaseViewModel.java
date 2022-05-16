package k15hkii.se114.bookstore.viewmodel.base;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;

public abstract class BaseViewModel extends ViewModel {

    private final ObservableBoolean isLoading = new ObservableBoolean();

    @Inject private SchedulerProvider schedulerProvider;

    private CompositeDisposable compositeDisposable;

    @Override
    protected void onCleared() {
        compositeDisposable.dispose();
        super.onCleared();
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    public ObservableBoolean getIsLoading() {
        return isLoading;
    }

    public void setIsLoading(boolean isLoading) {
        this.isLoading.set(isLoading);
    }

}
