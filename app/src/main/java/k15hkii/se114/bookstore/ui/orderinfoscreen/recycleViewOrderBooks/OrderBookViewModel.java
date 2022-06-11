package k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks;

import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.bill.BillDetail;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import lombok.Getter;

import javax.inject.Inject;

public class OrderBookViewModel extends BaseViewModel<OrderBooksViewNavigator> {

    @Inject
    protected ModelRemote remote;

    public final ObservableField<Integer> price = new ObservableField<>();
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<Integer> quantity = new ObservableField<>();

    @Getter
    private Book book;
    @Getter
    private BillDetail billDetail;

    private void setData() {
        remote.getBook(billDetail.getBookId()).doOnSuccess(book -> {
            this.book = book;
            this.price.set(book.getPrice());
            this.name.set(book.getTitle());
            this.quantity.set(billDetail.getQuantity());
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
