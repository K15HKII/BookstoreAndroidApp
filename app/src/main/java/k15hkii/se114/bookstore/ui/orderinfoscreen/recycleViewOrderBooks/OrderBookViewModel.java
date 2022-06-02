package k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks;

import android.util.Log;
import androidx.databinding.Bindable;
import k15hkii.se114.bookstore.data.model.api.Bill;
import k15hkii.se114.bookstore.data.model.api.BillDetail;
import k15hkii.se114.bookstore.data.model.api.Book;
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

    private Book book;
    private BillDetail billDetail;
    private Bill bill;
    private int billId;
    private String bookId;

    private void setData() {
        remote.getBook(billDetail.getBookId()).doOnSuccess(book -> {
            this.book = book;
        }).subscribe();
    }

    public void setOrderDetail(BillDetail billDetail) {
        this.billDetail = billDetail;
    }

    @Bindable
    public String getName() {
        return billDetail == null ? "profile is null" : book.getTitle();
    }

    @Bindable
    public String getPrice() {
        return billDetail == null ? "null" : "đ" + String.valueOf(billDetail.getPrice());
    }

    @Bindable
    public String getQuantity() {
        return billDetail == null ? "null" : billDetail.getQuantity() + "";
    }

    public OrderBookViewModel() {
        super(null);
        setData();
    }


}
