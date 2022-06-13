package k15hkii.se114.bookstore.ui.orderinfoscreen;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableLong;
import io.reactivex.Observable;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.data.model.api.Payment;
import k15hkii.se114.bookstore.data.model.api.bill.Bill;
import k15hkii.se114.bookstore.data.model.api.user.UserAddress;
import k15hkii.se114.bookstore.data.model.api.user.UserBank;
import k15hkii.se114.bookstore.data.model.api.voucher.Voucher;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.base.INavigator;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

public class BaseOrderInfoViewModel<N extends INavigator> extends BaseViewModel<N> {

    public final ObservableField<List<OrderBookViewModel>> items = new ObservableField<>();
    public final ObservableField<UserAddress> address = new ObservableField<>();
    public final ObservableField<UserBank> bank = new ObservableField<>();
    public final ObservableLong price = new ObservableLong();
    public final ObservableField<Payment> paymentMethod = new ObservableField<>();
    public final ObservableLong shipPay = new ObservableLong();
    public final ObservableLong total = new ObservableLong();

    @Getter
    private UUID userId;
    @Getter
    private int billId;
    @Getter
    private Bill bill;
    @Getter private Voucher voucher;

    protected final ViewModelMapper mapper;
    protected final ModelRemote remote;

    public BaseOrderInfoViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, ModelRemote remote) {
        super(schedulerProvider);
        this.mapper = mapper;
        this.remote = remote;

        OnPropertyChangedCallback callback = new OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(androidx.databinding.Observable sender, int propertyId) {
                refreshTotal();
            }
        };
        price.addOnPropertyChangedCallback(callback);
        shipPay.addOnPropertyChangedCallback(callback);
    }

    @Override
    public void initializeFromBundle(@NonNull @NotNull Bundle bundle) {
        super.initializeFromBundle(bundle);
        Bill bill = (Bill) bundle.getSerializable("bill");
        if (bill != null) {
            setBill(bill);
        }
    }

    @Bindable
    public String getVoucherDescription() {
        if (voucher == null) {
            return "Không có";
        }
        return voucher.getDescription();
    }

    @Bindable
    public long getVoucherDiscount() {
        if (voucher == null) {
            return 0;
        }
        return -voucher.getDiscount(price.get());
    }

    public void setPaymentMethod(Payment payment) {
        paymentMethod.set(payment);
    }

    public void setVoucher(Voucher voucher) {
        if (voucher == null)
            return;
        this.voucher = voucher;
        refreshTotal();
        notifyPropertyChanged(BR.voucherDescription);
    }

    public void setBillId(int billId) {
        dispose(remote.getBill(billId), this::setBill, error -> {
            Log.e("OrderInfoPageViewModel", "Error get bill", error);
        });
    }

    public void setBill(Bill bill) {
        this.bill = bill;

        userId = bill.getUserId();
        billId = bill.getId();

        items.set(mapper.toOrderBookViewModels(bill.getBillDetails()));

        paymentMethod.set(bill.getPayment());

        dispose(remote.getAddress(bill.getUserId(), bill.getUserAddressId()),
                this.address::set,
                throwable -> {
                    Log.d("OrderRatingViewModel", "getAddress: " + throwable.getMessage());
                });

        //region Get total
        dispose(Observable.fromIterable(bill.getBillDetails())
                .map(detail -> detail.getPrice() * detail.getQuantity())
                .reduceWith(() -> 0d, (a, b) -> a + b).map(Double::longValue), this.price::set, throwable -> {
            Log.d("OrderRatingViewModel", "getData: ", throwable);
        });
    }

    private void refreshTotal() {
        total.set(price.get() + shipPay.get() + getVoucherDiscount());
        notifyPropertyChanged(BR.voucherDiscount);
    }

}
