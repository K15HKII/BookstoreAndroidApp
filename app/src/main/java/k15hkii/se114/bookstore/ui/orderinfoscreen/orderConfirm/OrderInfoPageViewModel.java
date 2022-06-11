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
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class OrderInfoPageViewModel extends BaseViewModel<OrderInfoPageNavigator> implements Observable {

    public final ObservableField<List<OrderBookViewModel>> items = new ObservableField<>();

    public final ObservableField<String> address = new ObservableField<>();
    public final ObservableField<String> voucher = new ObservableField<>();
    public final ObservableField<Integer> price = new ObservableField<>();
    public final ObservableField<String> paymentMethod = new ObservableField<>();
    public final ObservableField<Integer> discount = new ObservableField<>();
    public final ObservableField<Integer> shipPay = new ObservableField<>();
    public final ObservableField<Integer> total = new ObservableField<>();

    @Inject
    protected ViewModelMapper mapper;

    @Inject
    protected ModelRemote remote;

    private Bill bill;

    private int billId;
    private UUID userId;

    List<OncartItemViewModel> onCartItems;

    public void getData() {
        List<OrderBookViewModel> orderList = new ArrayList<>();
        int p = 0;
        for (OncartItemViewModel item : onCartItems) {
            OrderBookViewModel orderBookViewModel = new OrderBookViewModel(remote);
            orderBookViewModel.name.set(item.name.get());
            orderBookViewModel.quantity.set(item.quantity.get());
            orderBookViewModel.price.set(item.price.get());
            orderList.add(orderBookViewModel);
            p += item.price.get();
        }
        items.set(orderList);
        dispose(remote.getAddresses(userId),
                userAddresses -> {
                    for (UserAddress addressItem : userAddresses) {
                        if (addressItem.is_primary()) {
                            address.set(addressItem.getCity());
                            return;
                        }
                    }
                    voucher.set("Chọn");
                    paymentMethod.set("Chọn");
                },
                throwable -> { });

        price.set(p);
        discount.set(0);
        shipPay.set(0);
        total.set(price.get() + shipPay.get() - discount.get());
    }

    //todo: create bill
    public void setData() {
//        if (!Objects.equals(voucher.get(), "Chọn")) {
//            discount.set();
//        }
    }

    @Override
    public void initializeFromBundle(@NonNull @NotNull Bundle bundle) {
        super.initializeFromBundle(bundle);
        onCartItems = (List<OncartItemViewModel>) bundle.getSerializable("orderList");
        userId = (UUID) bundle.getSerializable("userId");
        getData();
    }

    public OrderInfoPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, ViewModelMapper mapper) {
        super(schedulerProvider);
        this.mapper = mapper;
        this.remote = remote;
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

    public void openSuccessOrder() {
        //TODO: Create Bill, chưa fix hàm create
        getNavigator().SucceedOrder();
    }
}
