package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.cancleorder;

import k15hkii.se114.bookstore.data.model.api.bill.BillStatus;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.BaseOrderListViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class CancelOrderViewModel extends BaseOrderListViewModel<CancleOrderNavigator> {

    public CancelOrderViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper preferencesHelper) {
        super(schedulerProvider, mapper, BillStatus.CANCELED, preferencesHelper);
    }

}
