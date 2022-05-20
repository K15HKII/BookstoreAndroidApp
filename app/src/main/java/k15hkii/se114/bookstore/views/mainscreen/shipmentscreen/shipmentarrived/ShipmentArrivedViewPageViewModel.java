package k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.shipmentarrived;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;

public class ShipmentArrivedViewPageViewModel extends BaseViewModel<ShipmentArrivedViewPageNavigator> implements Observable {
    public ShipmentArrivedViewPageViewModel(SchedulerProvider schedulerProvider) {
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
