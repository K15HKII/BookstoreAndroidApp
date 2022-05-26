package k15hkii.se114.bookstore.ui.orderinfoscreen;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.RecycleViewOrderBooks.OrderBookViewModel;

import java.util.Arrays;
import java.util.List;

public class OrderInfoPageViewModel extends BaseViewModel<OrderInfoPageNavigator> implements Observable {

    private final MutableLiveData<List<OrderBookViewModel>> orderBookInfoItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new OrderBookViewModel("Dac nhan tam"),
                          new OrderBookViewModel("Nguoi phan xu"))
    );

    public List<OrderBookViewModel> getOrderBookInfoItems() {
        return orderBookInfoItemsLiveData.getValue();
    }

    public OrderInfoPageViewModel(SchedulerProvider schedulerProvider) {
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
    // TODO: Implement the ViewModel
}
