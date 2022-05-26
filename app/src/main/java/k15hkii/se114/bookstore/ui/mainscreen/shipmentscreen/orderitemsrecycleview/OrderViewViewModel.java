package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview;

import k15hkii.se114.bookstore.data.model.api.Bill;
import k15hkii.se114.bookstore.data.model.api.BillDetail;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.List;

public class OrderViewViewModel extends BaseViewModel<OrderViewNavigator> {

    @Inject protected ModelRemote remote;

    private Bill bill;
    private String billId;
    private List<BillDetail> billDetails;
    public void setListOrder(String billId) {
        this.billId = billId;

        remote.getBill(billId).doOnSuccess(bill -> {
            this.bill = bill;
        }).subscribe();
        remote.getBilldetails(billId).doOnSuccess(billDetails -> {
            this.billDetails = billDetails;
        }).subscribe();
    }
    String price;
    String note;
    List<OrderItemViewModel> lsOrderItem;

    public OrderViewViewModel(String price, String note, List<OrderItemViewModel> lsOrderItem) {
        super(null);
        this.price = price;
        this.note = note;
        this.lsOrderItem = lsOrderItem;
    }

    public List<OrderItemViewModel> getLsBooks() {
        return lsOrderItem;
    }

    public void setLsBooks(List<OrderItemViewModel> lsBooks) {
        this.lsOrderItem = lsBooks;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
