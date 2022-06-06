package k15hkii.se114.bookstore.ui.orderinfoscreen.orderratingdetail;

import android.util.Log;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.Bill;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import java.util.List;
import java.util.UUID;

public class OrderRatingDetailViewModel extends BaseViewModel<OrderRatingDetailNavigator> {

    public final ObservableField<List<OrderBookViewModel>> items = new ObservableField<>();

    protected ViewModelMapper mapper;
    private Bill bill;
    public void getData(int billId) {
        dispose(mapper.getBill(billId),
                items::set,
                throwable -> Log.d("OrderInfoPageViewModel", "getData: " + throwable.getMessage(), throwable));
    }

    public OrderRatingDetailViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper) {
        super(schedulerProvider);
        this.mapper = mapper;
        getData(1);
    }
    @Bindable
    public String getPayment(){
        return bill == null ? "null" : bill.getPayment().toString();
    }

    @Bindable
    public  String getDiscount(){
        return bill == null ? "null" : "Giảm giá " + bill.getVoucherProfile().getDiscount() + " %";
    }

    @Bindable
    public String getAddress(){
        return bill == null ? "null" : bill.getUserAddress().getNumber() + ", " + bill.getUserAddress().getStreet() + ", " + bill.getUserAddress().getCity()+ ", " + bill.getUserAddress().getCountry();
    }
    public void onBackWardClick(){
        getNavigator().BackWard();
    }
}
