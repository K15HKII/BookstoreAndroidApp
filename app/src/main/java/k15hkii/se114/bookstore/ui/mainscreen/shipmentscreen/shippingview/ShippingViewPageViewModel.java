package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.shippingview;

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

public class ShippingViewPageViewModel extends BaseViewModel<ShippingViewPageNavigator> implements Observable {

    public final ObservableField<List<OrderViewViewModel>> listOrder = new ObservableField<>(
            Arrays.asList(new OrderViewViewModel("240.000", "note", getOrderListItem(2)),
                          new OrderViewViewModel("120.000", "note", getOrderListItem(1)))
    );

    public List<OrderItemViewModel> getOrderListItem(int quantity) {

        List<OrderItemViewModel> orderListItem = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            orderListItem.add(new OrderItemViewModel("Dac nhan tam"));
        }

        return orderListItem;
    }

    public ShippingViewPageViewModel(SchedulerProvider schedulerProvider) {
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
