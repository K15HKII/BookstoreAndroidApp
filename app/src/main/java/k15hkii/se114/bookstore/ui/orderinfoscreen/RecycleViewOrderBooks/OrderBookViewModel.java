package k15hkii.se114.bookstore.ui.orderinfoscreen.RecycleViewOrderBooks;

import k15hkii.se114.bookstore.data.model.api.BillDetail;
import k15hkii.se114.bookstore.data.model.api.BookProfile;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

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
        remote.getBilldetail(billId, bookId).doOnSuccess(billDetail -> {
            this.billDetail = billDetail;
        }).subscribe();
    }

    String name;

    public OrderBookViewModel(String name) {
        super(null);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
