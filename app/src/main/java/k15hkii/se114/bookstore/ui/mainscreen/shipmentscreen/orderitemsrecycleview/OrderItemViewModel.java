package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview;

import androidx.databinding.Bindable;
import k15hkii.se114.bookstore.data.model.api.BillDetail;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.model.api.File;
import k15hkii.se114.bookstore.data.model.api.Image;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;
import java.util.List;

public class OrderItemViewModel extends BaseViewModel<OrderItemNavigator> {

    @Inject protected ModelRemote remote;

    private BillDetail billDetail;
    private Book book;
    private List<Image> bookImages;
    private String billId;
    private String bookProfileId;

    public void setBillDetail(BillDetail billDetail) {
        this.billDetail = billDetail;

        remote.getBook(billDetail.getBookId()).doOnSuccess(book -> {
            this.book = book;
            bookProfileId = String.valueOf(book.getId());
        }).subscribe();

        remote.getBookImages().doOnSuccess(bookImages -> {
            this.bookImages = bookImages;
        }).subscribe();
    }

    @Bindable
    @Getter
    @Setter
    private String Name;

    public OrderItemViewModel(String name) {
        super(null);
        this.Name = name;
    }
}
