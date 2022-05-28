package k15hkii.se114.bookstore.ui.orderinfoscreen.orderratingdetail;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import java.util.Arrays;
import java.util.List;

public class OrderRatingDetailViewModel extends BaseViewModel<OrderRatingDetailNavigator> {
    private final MutableLiveData<List<OrderBookViewModel>> orderBookInfoItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new OrderBookViewModel("Dac nhan tam"),
                    new OrderBookViewModel("Nguoi phan xu"))
    );

    public List<OrderBookViewModel> getOrderBookInfoItems() {
        return orderBookInfoItemsLiveData.getValue();
    }

    public OrderRatingDetailViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }
}
