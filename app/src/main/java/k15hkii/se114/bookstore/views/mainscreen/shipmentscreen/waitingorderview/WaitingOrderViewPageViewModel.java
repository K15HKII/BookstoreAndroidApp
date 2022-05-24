package k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.waitingorderview;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;
import k15hkii.se114.bookstore.views.mainscreen.homechipnavigator.BookView;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.orderitemsrecycleview.OrderItem;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.orderitemsrecycleview.OrderView;
import k15hkii.se114.bookstore.views.orderinfoscreen.RecycleViewOrderBooks.OrderBookView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaitingOrderViewPageViewModel extends BaseViewModel<WaitingOrderViewPageNavigator> implements Observable {

    private final MutableLiveData<List<OrderView>> waitingOrderItemsLiveData = new MutableLiveData<>(
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

    public List<OrderView> getWaitingOrderItems() {
        return waitingOrderItemsLiveData.getValue();
    }

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
