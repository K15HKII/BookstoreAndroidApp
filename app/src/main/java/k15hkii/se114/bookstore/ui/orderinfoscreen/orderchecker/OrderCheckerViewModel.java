package k15hkii.se114.bookstore.ui.orderinfoscreen.orderchecker;

import android.util.Log;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import java.util.List;

public class OrderCheckerViewModel extends BaseViewModel<OrderCheckerNavigator> {

    public final ObservableField<List<OrderBookViewModel>> items = new ObservableField<>();

    protected ViewModelMapper mapper;

    public OrderCheckerViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper) {
        super(schedulerProvider);
        this.mapper = mapper;
        getData(1);
    }

    public void getData(int billId) {
        dispose(mapper.getBill(billId),
                items::set,
                throwable -> Log.d("OrderInfoPageViewModel", "getData: " + throwable.getMessage(), throwable));
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }
}
