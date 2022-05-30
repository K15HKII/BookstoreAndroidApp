package k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks;

import androidx.databinding.Bindable;
import k15hkii.se114.bookstore.data.model.api.BillDetail;
import k15hkii.se114.bookstore.data.model.api.BookProfile;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;

public class OrderBookViewModel extends BaseViewModel<OrderBooksViewNavigator> {

    @Inject
    protected ModelRemote remote;

    private BookProfile bookProfile;
    private BillDetail billDetail;
    private String billId;
    private String bookId;

    public void getOrderView(String billId, String bookId) {
        remote.getBookprofile(bookId).doOnSuccess(bookProfile -> {
            this.bookProfile = bookProfile;
        }).subscribe();
    }

    @Bindable
    private @Getter @Setter
    String Name;

    public OrderBookViewModel(String name) {
        super(null);
        this.Name = name;
    }


}
