package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.bill.Bill;
import k15hkii.se114.bookstore.data.model.api.bill.BillDetail;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import lombok.Getter;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class OrderViewViewModel extends BaseViewModel<IOrderNavigator> implements Observable {

    public final ObservableField<List<OrderItemViewModel>> items = new ObservableField<>();
    public final ObservableField<String> note = new ObservableField<>();
    public final ObservableField<Integer> price = new ObservableField<>();

    @Inject protected ModelRemote remote;

    @Getter private Bill bill;

    private int billId;

    public OrderViewViewModel(ModelRemote remote) {
        super(null);
        this.remote = remote;
    }

    int totalPrice;

    public void getData() {

        totalPrice = 0;

        List<OrderItemViewModel> list = new ArrayList<>();
        for (BillDetail billDetail : bill.getBillDetails()) {
            OrderItemViewModel item = new OrderItemViewModel(this.remote);
            item.setBillDetail(billDetail);

            remote.getBook(billDetail.getBookId()).doOnSuccess(book -> {
                totalPrice += book.getPrice();
            }).subscribe();

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
