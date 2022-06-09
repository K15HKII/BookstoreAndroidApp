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
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

public class OrderDetailViewModel extends BaseViewModel<OrderDetailNavigator> implements Observable {

    public final ObservableField<List<OrderBookViewModel>> items = new ObservableField<>();

    public final ObservableField<String> address = new ObservableField<>();
    public final ObservableField<String> voucher = new ObservableField<>();
    public final ObservableField<String> price = new ObservableField<>();
    public final ObservableField<String> paymentMethod = new ObservableField<>();
    public final ObservableField<String> discount = new ObservableField<>();
    private Bill bill;

    @Inject
    protected ViewModelMapper mapper;
    @Inject
    protected ModelRemote remote;

    public void getData(int billId) {
        dispose(mapper.getBill(billId),
                billdetails -> {
                    items.set(billdetails);
//                    setPrice(bill.getPrice());

                    //todo: get address
//                    this.voucher.set(bill.getVoucherProfile().getName());
//                    this.paymentMethod.set(bill.getPayment().name());
//                    remote.getTransporter(bill.getTransportId()).doOnSuccess(transporter -> {
//                        shippingPay.set(transporter.getName());
//                    }).subscribe();

                    double totalPrice = 0;

                    for (OrderBookViewModel item : Objects.requireNonNull(items.get())) {

                        totalPrice += Double.parseDouble(Objects.requireNonNull(item.price.get()));
                    }

                    this.price.set(String.valueOf(totalPrice));
                },
                throwable -> Log.d("OrderInfoPageViewModel", "getData: " + throwable.getMessage(), throwable));

    }

    @Override
    public void initializeFromBundle(@NonNull Bundle bundle) {
        super.initializeFromBundle(bundle);
        Bill bill = (Bill) bundle.getSerializable("bill");
        if (bill != null) {
            setBill(bill);
        }
    }

    public void setBill(Bill bill) {
        this.bill = bill;
        getData(bill.getId());
    }

    public OrderDetailViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper) {
        super(schedulerProvider);
        this.mapper = mapper;
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
}
