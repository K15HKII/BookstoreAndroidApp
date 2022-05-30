package k15hkii.se114.bookstore.ui.orderinfoscreen.orderratingdetail;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import java.util.Arrays;
import java.util.List;

public class OrderRatingDetailViewModel extends BaseViewModel<OrderRatingDetailNavigator> {
    public final ObservableField<List<OrderBookViewModel>> listOrderBooks = new ObservableField<>(
            Arrays.asList(new OrderBookViewModel("Dac nhan tam"),
                    new OrderBookViewModel("Nguoi phan xu"))
    );

    public OrderRatingDetailViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }
}
