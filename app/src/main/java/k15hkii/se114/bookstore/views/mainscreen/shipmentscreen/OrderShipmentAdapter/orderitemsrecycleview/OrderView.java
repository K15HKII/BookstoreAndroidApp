package k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.OrderShipmentAdapter.orderitemsrecycleview;

import java.util.List;

public class OrderView {
    String price;
    String note;
    List<OrderItem> lsOrderItem;

    public OrderView(String price, String note, List<OrderItem> lsOrderItem) {
        this.price = price;
        this.note = note;
        this.lsOrderItem = lsOrderItem;
    }

    public List<OrderItem> getLsBooks() {
        return lsOrderItem;
    }

    public void setLsBooks(List<OrderItem> lsBooks) {
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
