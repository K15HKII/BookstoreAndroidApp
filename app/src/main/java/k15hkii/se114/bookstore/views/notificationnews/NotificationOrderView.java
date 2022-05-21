package k15hkii.se114.bookstore.views.notificationnews;

import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.OrderShipmentAdapter.orderitemsrecycleview.OrderItem;

import java.util.List;

public class NotificationOrderView {
    private String title;
    private String price;
    private String description;
    private List<OrderItem> lsorderItems;

    public NotificationOrderView(String title, String price, String description, List<OrderItem> lsorderItems) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.lsorderItems = lsorderItems;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OrderItem> getLsorderItems() {
        return lsorderItems;
    }

    public void setLsorderItems(List<OrderItem> lsorderItems) {
        this.lsorderItems = lsorderItems;
    }
}
