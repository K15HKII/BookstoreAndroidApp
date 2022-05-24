package k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.shippingview;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.OrderShipmentAdapter.orderitemsrecycleview.OrderItem;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.OrderShipmentAdapter.orderitemsrecycleview.OrderView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShippingViewPageViewModel extends BaseViewModel<ShippingViewPageNavigator> implements Observable {

    private final MutableLiveData<List<OrderView>> shippingOrderItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new OrderView("240.000", "note", getOrderListItem(2)),
                          new OrderView("120.000", "note", getOrderListItem(1)))
    );

    public List<OrderItem> getOrderListItem(int quantity) {

        List<OrderItem> orderListItem = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            orderListItem.add(new OrderItem("Dac nhan tam"));
        }

        return orderListItem;
    }

    public List<OrderView> getShippingOrderItems() {
        return shippingOrderItemsLiveData.getValue();
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
