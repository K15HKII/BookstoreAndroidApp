package k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks;

import android.util.Log;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import k15hkii.se114.bookstore.data.model.api.bill.BillDetail;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Getter;

import javax.inject.Inject;

public class OrderBookViewModel extends BaseViewModel<OrderBooksViewNavigator> {

    @Inject
    protected ModelRemote remote;

    public final ObservableInt price = new ObservableInt();
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableInt quantity = new ObservableInt();
    public final ObservableField<Image> image = new ObservableField<>();

    @Getter
    private Book book;
    @Getter
    private BillDetail billDetail;

    public void setBook(Book book, int quantity) {
        this.book = book;
        this.name.set(book.getTitle());
        this.quantity.set(quantity);
        this.price.set(book.getPrice() * quantity);
        if (book.getImages() != null && book.getImages().size() > 0) {
            image.set(book.getImages().get(0));
        }
    }

    public void setOrderDetail(BillDetail billDetail) {
        this.billDetail = billDetail;
        this.quantity.set(billDetail.getQuantity());
        dispose(remote.getBook(billDetail.getBookId()), book -> {
            setBook(book, billDetail.getQuantity());
        }, throwable -> {
            Log.d("", "GetBook: " + throwable.getMessage(), throwable);
        });
    }

    public OrderBookViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
    }
}
