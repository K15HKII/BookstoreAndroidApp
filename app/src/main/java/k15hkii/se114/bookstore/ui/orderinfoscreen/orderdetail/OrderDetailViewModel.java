package k15hkii.se114.bookstore.ui.orderinfoscreen.orderdetail;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import java.util.Arrays;
import java.util.List;

public class OrderDetailViewModel extends BaseViewModel<OrderDetailNavigator> implements Observable {

    private final MutableLiveData<List<OrderBookViewModel>> orderBookInfoItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new OrderBookViewModel("Dac nhan tam"),
                    new OrderBookViewModel("Nguoi phan xu"))
    );

    public List<OrderBookViewModel> getOrderBookInfoItems() {
        return orderBookInfoItemsLiveData.getValue();
    }

    public OrderDetailViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
}
