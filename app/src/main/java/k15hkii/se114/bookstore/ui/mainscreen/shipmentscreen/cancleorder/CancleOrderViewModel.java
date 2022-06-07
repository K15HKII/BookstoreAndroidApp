package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.cancleorder;

import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.databinding.CancleOrderFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderViewViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import java.util.List;

public class CancleOrderViewModel extends BaseViewModel<CancleOrderNavigator> {

    public CancleOrderViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }
    public final ObservableField<List<OrderViewViewModel>> items = new ObservableField<>();
}
