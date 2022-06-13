package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview;

import android.util.Log;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.bill.BillDetail;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;

public class OrderItemViewModel extends BaseViewModel<OrderItemNavigator> {

    @Inject
    protected ModelRemote remote;

    public final ObservableField<Image> image = new ObservableField<>();
    public final ObservableField<String> title = new ObservableField<>();
    public final ObservableField<Long> price = new ObservableField<>();

    private BillDetail billDetail;
    private Book book;

    public OrderItemViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
    }

    public void setBillDetail(BillDetail billDetail) {
        this.billDetail = billDetail;
        dispose(remote.getBook(billDetail.getBookId()), book -> {
            setBook(book);
        }, throwable -> {
            Log.d("", "GetBook: " + throwable.getMessage(), throwable);
        });
    }

    public void setBook(Book book) {
        if (book == null)
            return;
        this.book = book;
        if (book.getImages() != null && book.getImages().size() > 0) {
            image.set(book.getImages().get(0));
        }
        title.set(book.getTitle());
        price.set((long) book.getPrice());
    }

}
