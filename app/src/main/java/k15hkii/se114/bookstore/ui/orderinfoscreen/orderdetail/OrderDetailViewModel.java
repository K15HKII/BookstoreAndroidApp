package k15hkii.se114.bookstore.ui.orderinfoscreen.orderdetail;

import android.util.Log;

import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.orderinfoscreen.BaseOrderInfoViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class OrderDetailViewModel extends BaseOrderInfoViewModel<OrderDetailNavigator> {

    public OrderDetailViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, ModelRemote remote) {
        super(schedulerProvider, mapper, remote);
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

    public void DeleteOrderClick() {
        dispose(remote.deleteBill(getUserId(), getBillId()),
                a -> { },
                throwable -> Log.d("", "Delete: " + throwable.getMessage(), throwable));
    }

}
