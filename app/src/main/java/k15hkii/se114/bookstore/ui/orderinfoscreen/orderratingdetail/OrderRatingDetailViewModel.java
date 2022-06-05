package k15hkii.se114.bookstore.ui.orderinfoscreen.orderratingdetail;

import android.util.Log;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import java.util.List;

public class OrderRatingDetailViewModel extends BaseViewModel<OrderRatingDetailNavigator> {

    public final ObservableField<List<OrderBookViewModel>> items = new ObservableField<>();

    protected ViewModelMapper mapper;

    public void getData(int billId) {
        dispose(mapper.getBill(billId),
                items::set,
                throwable -> Log.d("OrderInfoPageViewModel", "getData: " + throwable.getMessage(), throwable));
    }

    public OrderRatingDetailViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper) {
        super(schedulerProvider);
        this.mapper = mapper;
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }
}
