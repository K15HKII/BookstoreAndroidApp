package k15hkii.se114.bookstore.viewmodel.base;

import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.PropertyChangeRegistry;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public abstract class ObservableViewModel extends BaseViewModel implements Observable {

    private final PropertyChangeRegistry callbacks = new PropertyChangeRegistry();

    public ObservableViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        callbacks.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        callbacks.remove(callback);
    }

    protected void notifyChange() {
        callbacks.notifyCallbacks(this, 0, null);
    }

    protected void notifyPropertyChanged(int fieldId) {
        callbacks.notifyCallbacks(this, fieldId, null);
    }

}
