package k15hkii.se114.bookstore.ui.orderinfoscreen.orderchecker;

import android.util.Log;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.Bill;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import java.util.List;

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
                items::set,
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
