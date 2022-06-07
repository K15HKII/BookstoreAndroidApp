package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview;

import androidx.databinding.Bindable;
import k15hkii.se114.bookstore.data.model.api.BillDetail;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.model.api.File;
import k15hkii.se114.bookstore.data.model.api.Image;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;
import java.util.List;

public class OrderItemViewModel extends BaseViewModel<OrderItemNavigator> {

    @Inject protected ModelRemote remote;

    private BillDetail billDetail;
    private Book book;

    private List<Image> bookImages;

    // todo: binding data
    @Bindable
    public String getName() {
        return billDetail == null ? "profile is null" : book.getTitle();
    }

    @Bindable
    public String getPrice() {
        return billDetail == null ? "profile is null" : String.valueOf(book.getPrice());
    }

    public OrderItemViewModel(ModelRemote remote) {
        super(null);
        this.remote = remote;
    }

    public void setBillDetail(BillDetail billDetail) {
        this.billDetail = billDetail;

        remote.getBook(billDetail.getBookId()).doOnSuccess(book -> {
            this.book = book;
        }).subscribe();

        /*remote.getBookImages().doOnSuccess(bookImages -> {
            this.bookImages = bookImages;
        }).subscribe();*/ //TODO:
    }
}
