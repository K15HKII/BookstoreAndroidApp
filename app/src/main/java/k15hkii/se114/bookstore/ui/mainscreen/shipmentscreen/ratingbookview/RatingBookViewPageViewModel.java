package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.ratingbookview;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderItem;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatingBookViewPageViewModel extends BaseViewModel<RatingBookViewPageNavigator> implements Observable {

    private final MutableLiveData<List<OrderView>> ratingBookItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new OrderView("240.000", "note", getOrderListItem(1)),
                          new OrderView("120.000", "note", getOrderListItem(2)))
    );

    public List<OrderItem> getOrderListItem(int quantity) {

        List<OrderItem> orderListItem = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            orderListItem.add(new OrderItem("Dac nhan tam"));
        }

        return orderListItem;
    }

    public List<OrderView> getRatingBookItems() {
        return ratingBookItemsLiveData.getValue();
    }

    public RatingBookViewPageViewModel(SchedulerProvider schedulerProvider) {
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
