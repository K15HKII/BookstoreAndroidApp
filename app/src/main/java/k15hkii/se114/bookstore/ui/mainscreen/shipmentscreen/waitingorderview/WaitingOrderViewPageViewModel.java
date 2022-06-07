package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.waitingorderview;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderViewViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderItemViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaitingOrderViewPageViewModel extends BaseViewModel<WaitingOrderViewPageNavigator> implements Observable {

    public final ObservableField<List<OrderViewViewModel>> listOrder = new ObservableField<>();


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
