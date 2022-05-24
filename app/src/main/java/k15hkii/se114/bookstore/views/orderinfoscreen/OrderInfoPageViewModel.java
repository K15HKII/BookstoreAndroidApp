package k15hkii.se114.bookstore.views.orderinfoscreen;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.orderitemsrecycleview.OrderView;
import k15hkii.se114.bookstore.views.orderinfoscreen.RecycleViewOrderBooks.OrderBookView;

import java.util.Arrays;
import java.util.List;

public class OrderInfoPageViewModel extends BaseViewModel<OrderInfoPageNavigator> implements Observable {

    private final MutableLiveData<List<OrderBookView>> orderBookInfoItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new OrderBookView("Dac nhan tam"),
                          new OrderBookView("Nguoi phan xu"))
    );

    public List<OrderBookView> getOrderBookInfoItems() {
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
