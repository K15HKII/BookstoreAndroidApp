package k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks;

import android.util.Log;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.Bill;
import k15hkii.se114.bookstore.data.model.api.BillDetail;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.model.api.Voucher;
import k15hkii.se114.bookstore.data.model.api.user.UserAddress;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class OrderBookViewModel extends BaseViewModel<OrderBooksViewNavigator> {

    @Inject
    protected ModelRemote remote;

    public final ObservableField<String> price = new ObservableField<>();
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> quantity = new ObservableField<>();

    private Book book;
    private BillDetail billDetail;

    private void setData() {
        remote.getBook(billDetail.getBookId()).doOnSuccess(book -> {
            this.book = book;
            this.price.set(String.valueOf(book.getPrice()));
            this.name.set(book.getTitle());
            this.quantity.set(String.valueOf(billDetail.getQuantity()));
        }).subscribe();
    }

    public void setOrderDetail(BillDetail billDetail) {
        this.billDetail = billDetail;
        setData();
    }

    public OrderBookViewModel(ModelRemote remote) {
        super(null);
        this.remote = remote;
    }
}
