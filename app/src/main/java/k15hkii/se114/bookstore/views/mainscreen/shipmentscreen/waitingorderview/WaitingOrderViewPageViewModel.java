package k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.waitingorderview;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;

public class WaitingOrderViewPageViewModel extends BaseViewModel<WaitingOrderViewPageNavigator> implements Observable {
    public WaitingOrderViewPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
