package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview;

import android.util.Log;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.bill.Bill;
import k15hkii.se114.bookstore.data.model.api.bill.BillDetail;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Getter;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class OrderViewViewModel extends BaseViewModel<IOrderNavigator> implements Observable {

    public final ObservableField<List<OrderItemViewModel>> items = new ObservableField<>();
    public final ObservableField<String> note = new ObservableField<>();
    public final ObservableField<Integer> price = new ObservableField<>();

    @Inject
    protected ModelRemote remote;

    @Getter
    private Bill bill;

    private int billId;

    public OrderViewViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
    }

    int totalPrice;

    public void getData() {

        totalPrice = 0;

        List<OrderItemViewModel> list = new ArrayList<>();
        for (BillDetail billDetail : bill.getBillDetails()) {
            OrderItemViewModel item = new OrderItemViewModel(this.getSchedulerProvider(), this.remote);
            item.setBillDetail(billDetail);

            dispose(remote.getBook(billDetail.getBookId()), book -> {
                totalPrice += book.getPrice();
            }, throwable -> {
                Log.d("", "GetBook: " + throwable.getMessage(), throwable);
            });

            list.add(item);
        }
        items.set(list);
        price.set(totalPrice);
    }

    public void setBill(Bill bill) {
        this.bill = bill;
        getData();
    }

}
