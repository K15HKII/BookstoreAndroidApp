package k15hkii.se114.bookstore.ui.notificationnews;

import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderItemViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.List;

public class NotificationOrderViewModel extends BaseViewModel<NotificationOrderViewNavigator> {

    @Inject protected ModelRemote remote;
    // todo: get data

    private String title;
    private String price;
    private String description;
    private List<OrderItemViewModel> lsorderItems;

    public NotificationOrderViewModel(String title, String price, String description, List<OrderItemViewModel> lsorderItems) {
        super(null);
        this.title = title;
        this.price = price;
        this.description = description;
        this.lsorderItems = lsorderItems;
    }

    public NotificationOrderViewModel(SchedulerProvider schedulerProvider) {
        super(null);

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

    public List<OrderItemViewModel> getLsorderItems() {
        return lsorderItems;
    }

    public void setLsorderItems(List<OrderItemViewModel> lsorderItems) {
        this.lsorderItems = lsorderItems;
    }
}
