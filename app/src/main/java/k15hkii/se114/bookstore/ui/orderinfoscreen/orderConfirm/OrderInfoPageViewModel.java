package k15hkii.se114.bookstore.ui.orderinfoscreen.orderConfirm;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.bill.Bill;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class OrderInfoPageViewModel extends BaseViewModel<OrderInfoPageNavigator> implements Observable {

    public final ObservableField<List<OrderBookViewModel>> items = new ObservableField<>();

    public final ObservableField<String> address = new ObservableField<>();
    public final ObservableField<String> voucher = new ObservableField<>();
    public final ObservableField<Integer> price = new ObservableField<>();
    public final ObservableField<String> paymentMethod = new ObservableField<>();
    public final ObservableField<Double> discount = new ObservableField<>();
    public final ObservableField<Integer> shipPay = new ObservableField<>();
    public final ObservableField<Integer> total = new ObservableField<>();

    @Inject
    protected ViewModelMapper mapper;

    @Inject
    protected ModelRemote remote;

    private Bill bill;

    private int billId;
    private UUID userId;

    public void getData() {
        dispose(mapper.getBill(billId),
                billdetails -> {
                    items.set(billdetails);

                    int totalPrice = 0;

                    for (OrderBookViewModel item : Objects.requireNonNull(items.get())) {

                        totalPrice += item.price.get();
                    }

                    this.price.set(totalPrice);
                    this.total.set(totalPrice - shipPay.get());
                },
                throwable -> Log.d("OrderInfoPageViewModel", "getData: " + throwable.getMessage(), throwable));
    }

    @Override
    public void initializeFromBundle(@NonNull @NotNull Bundle bundle) {
        super.initializeFromBundle(bundle);
        Bill bill = (Bill) bundle.getSerializable("bill");
        if (bill != null) {
            setBill(bill);
        }
    }

    public OrderInfoPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, ViewModelMapper mapper) {
        super(schedulerProvider);
        this.mapper = mapper;
        this.remote = remote;
    }

    public void setBill(Bill bill) {
        this.bill = bill;

        userId = bill.getUserid();
        billId = bill.getId();

        //get address
        dispose(remote.getAddress(userId, billId),
                address -> this.voucher.set(address.getCity()),
                throwable -> {});
        // get voucher
        dispose(remote.getBillVouchers(billId),
                vouchers -> this.voucher.set(vouchers.get(0).getName()),
                throwable -> {});
        // get payment
        this.paymentMethod.set(bill.getPayment().name());
        this.shipPay.set(10);
//                    remote.getTransporter(bill.getTransportId()).doOnSuccess(transporter -> {
//                        shippingPay.set(transporter.getName());
//                    }).subscribe();
        getData();
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    public void openSuccessOrder(){
        getNavigator().SucceedOrder();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }


    // TODO: Implement the ViewModel
}
