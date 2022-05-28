package k15hkii.se114.bookstore.ui.orderinfoscreen.orderchecker;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import java.util.Arrays;
import java.util.List;

public class OrderCheckerViewModel extends BaseViewModel<OrderCheckerNavigator> {
    public OrderCheckerViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }
    private final MutableLiveData<List<OrderBookViewModel>> orderBookInfoItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new OrderBookViewModel("Dac nhan tam"),
                    new OrderBookViewModel("Nguoi phan xu"))
    );

    public List<OrderBookViewModel> getOrderBookInfoItems() {
        return orderBookInfoItemsLiveData.getValue();
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }
}
