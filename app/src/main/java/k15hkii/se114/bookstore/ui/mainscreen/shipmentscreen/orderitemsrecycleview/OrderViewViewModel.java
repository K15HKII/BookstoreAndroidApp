package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.Bill;
import k15hkii.se114.bookstore.data.model.api.BillDetail;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

public class OrderViewViewModel extends BaseViewModel<IOrderNavigator> implements Observable {

    public final ObservableField<List<OrderItemViewModel>> orderItems = new ObservableField<>(Arrays.asList());

    @Inject protected ModelRemote remote;

    private Bill bill;
    private String billId;
    private List<BillDetail> billDetails;
    public void setListOrder(String billId) {
        this.billId = billId;

        remote.getBill(billId).doOnSuccess(bill -> {
            this.bill = bill;
        }).subscribe();
    }

    @Bindable
    @Setter @Getter private String price;
    @Setter @Getter private String note;
    @Setter @Getter private List<OrderItemViewModel> lsOrderItem;

    public OrderViewViewModel(String price, String note, List<OrderItemViewModel> lsOrderItem) {
        super(null);
        this.price = price;
        this.note = note;
        orderItems.set(lsOrderItem);
    }

}
