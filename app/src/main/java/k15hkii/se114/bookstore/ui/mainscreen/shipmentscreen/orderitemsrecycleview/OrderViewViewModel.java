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

    @Inject protected ModelRemote remote;

    @Getter private Bill bill;

    private int billId;
    private String note;
    private String price;

    @Bindable
    public String getNote() {
        return bill == null ? "profile is null" : bill.getStatus().name();
    }

    @Bindable
    public String getPrice() {
        return bill == null ? "profile is null" : price;
    }

    public OrderViewViewModel(ModelRemote remote) {
        super(null);
        this.remote = remote;
    }
    double totalPrice = 0;

    public void getData() {

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
        price = String.valueOf(totalPrice);
    }

    public void setBill(Bill bill) {
        this.bill = bill;
        getData();
    }


}
