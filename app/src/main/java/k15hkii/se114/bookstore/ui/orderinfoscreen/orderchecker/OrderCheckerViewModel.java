package k15hkii.se114.bookstore.ui.orderinfoscreen.orderchecker;

import android.util.Log;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.data.model.api.BillDetail;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderCheckerViewModel extends BaseViewModel<OrderCheckerNavigator> {

    public final ObservableField<List<OrderBookViewModel>> items = new ObservableField<>();

    protected ViewModelRemote remote;

    public OrderCheckerViewModel(SchedulerProvider schedulerProvider, ViewModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
        getData(1);
    }

    public void getData(int billId) {
        dispose(remote.getBill(billId),
                items::set,
                throwable -> Log.d("OrderInfoPageViewModel", "getData: " + throwable.getMessage(), throwable));
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }
}
