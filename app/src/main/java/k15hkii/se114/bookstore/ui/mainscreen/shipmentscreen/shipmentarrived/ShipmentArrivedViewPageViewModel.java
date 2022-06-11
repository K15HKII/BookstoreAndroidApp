package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.shipmentarrived;

import k15hkii.se114.bookstore.data.model.api.bill.BillStatus;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.BaseOrderListViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class ShipmentArrivedViewPageViewModel extends BaseOrderListViewModel<ShipmentArrivedViewPageNavigator> {

    public ShipmentArrivedViewPageViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper preferencesHelper) {
        super(schedulerProvider, mapper, BillStatus.COMPLETED, preferencesHelper);
    }

}
