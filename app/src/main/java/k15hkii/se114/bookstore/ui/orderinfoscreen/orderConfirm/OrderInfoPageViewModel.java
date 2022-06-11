package k15hkii.se114.bookstore.ui.orderinfoscreen.orderConfirm;

import android.location.Address;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.bill.Bill;
import k15hkii.se114.bookstore.data.model.api.cartitem.CartItem;
import k15hkii.se114.bookstore.data.model.api.user.UserAddress;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.oncartscreen.OncartItemViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.BaseOrderViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class OrderInfoPageViewModel extends BaseOrderViewModel<OrderInfoPageNavigator> {

    public OrderInfoPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, ViewModelMapper mapper) {
        super(schedulerProvider, mapper, remote);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    public void openSuccessOrder(){
        getNavigator().SucceedOrder();
    }

}
