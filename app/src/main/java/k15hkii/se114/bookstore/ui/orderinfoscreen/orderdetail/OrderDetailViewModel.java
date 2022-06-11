package k15hkii.se114.bookstore.ui.orderinfoscreen.orderdetail;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.bill.Bill;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.BaseOrderViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class OrderDetailViewModel extends BaseOrderViewModel<OrderDetailNavigator> {

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
