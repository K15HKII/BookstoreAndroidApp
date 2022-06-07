package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview;

import android.util.Log;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.Bill;
import k15hkii.se114.bookstore.data.model.api.BillDetail;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class OrderViewViewModel extends BaseViewModel<IOrderNavigator> implements Observable {

    public final ObservableField<List<OrderItemViewModel>> items = new ObservableField<>();

    @Inject protected ViewModelMapper mapper;
    @Inject protected ModelRemote remote;

    private Bill bill;

    private String note;
    private String price;

    @Bindable
    public String getNote() {
        return note == null ? "profile is null" : note;
    }

    @Bindable
    public String getPrice() {
        return price == null ? "profile is null" : price;
    }
    //todo: tinh' tong? gia'

//    public OrderViewViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper) {
//        super(schedulerProvider);
//        this.mapper = mapper;
//        getData();
//    }

    public OrderViewViewModel(ModelRemote remote) {
        super(null);
        this.remote = remote;
    }

    public void getData() {
        List<OrderItemViewModel> list = new ArrayList<>();
        for (BillDetail billDetail : bill.getBillDetails()) {
            OrderItemViewModel item = new OrderItemViewModel(this.remote);
            item.setBillDetail(billDetail);
            list.add(item);
        }
        items.set(list);
    }

    public void setBill(Bill bill) {
        this.bill = bill;
        getData();
    }
}
