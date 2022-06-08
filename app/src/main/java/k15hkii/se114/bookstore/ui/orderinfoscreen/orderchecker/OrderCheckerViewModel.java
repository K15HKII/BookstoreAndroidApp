package k15hkii.se114.bookstore.ui.orderinfoscreen.orderchecker;

import android.util.Log;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.Bill;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import java.util.List;
import java.util.Objects;

public class OrderCheckerViewModel extends BaseViewModel<OrderCheckerNavigator> {

    public final ObservableField<List<OrderBookViewModel>> items = new ObservableField<>();

    public final ObservableField<String> address = new ObservableField<>();
    public final ObservableField<String> voucher = new ObservableField<>();
    public final ObservableField<String> paymentMethod = new ObservableField<>();
    public final ObservableField<String> orderCheck = new ObservableField<>();
    public final ObservableField<String> shippingPay = new ObservableField<>();
    public final ObservableField<String> discount = new ObservableField<>();
    public final ObservableField<String> total = new ObservableField<>();

    protected ViewModelMapper mapper;
    private Bill bill;

    public OrderCheckerViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper) {
        super(schedulerProvider);
        this.mapper = mapper;
    }

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

                    this.total.set(String.valueOf(totalPrice));
                },
                throwable -> Log.d("OrderInfoPageViewModel", "getData: " + throwable.getMessage(), throwable));
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    public void setBill(Bill bill) {
        this.bill = bill;
        getData(bill.getId());
    }
}
