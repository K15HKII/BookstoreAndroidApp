package k15hkii.se114.bookstore.ui.orderinfoscreen.orderratingdetail;

import android.util.Log;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.BillDetail;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderRatingDetailViewModel extends BaseViewModel<OrderRatingDetailNavigator> {

    public final ObservableField<List<OrderBookViewModel>> items = new ObservableField<>();

    protected ViewModelRemote remote;

    public void getData(int billId) {
        dispose(remote.getBill(billId),
                items::set,
                throwable -> Log.d("OrderInfoPageViewModel", "getData: " + throwable.getMessage(), throwable));
    }

    public OrderRatingDetailViewModel(SchedulerProvider schedulerProvider, ViewModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }
}
