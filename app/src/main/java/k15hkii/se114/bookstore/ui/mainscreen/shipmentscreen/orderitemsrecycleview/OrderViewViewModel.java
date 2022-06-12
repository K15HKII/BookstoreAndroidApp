package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview;

import android.util.Log;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableLong;
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
    public final ObservableLong price = new ObservableLong();

    @Inject
    protected ModelRemote remote;

    @Getter
    private Bill bill;

    public OrderViewViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
        List<OrderItemViewModel> list = new ArrayList<>();
        for (BillDetail billDetail : bill.getBillDetails()) {
            OrderItemViewModel item = new OrderItemViewModel(this.getSchedulerProvider(), this.remote);
            item.setBillDetail(billDetail);
            list.add(item);
        }
        items.set(list);
        price.set(bill.getTotalDetails() + bill.getShipCost() - bill.getTotalDiscount());
    }

}
