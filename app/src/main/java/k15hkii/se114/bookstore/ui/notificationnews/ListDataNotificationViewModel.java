package k15hkii.se114.bookstore.ui.notificationnews;

import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.List;

public class ListDataNotificationViewModel extends BaseViewModel<ListDataNotificationNavigator> {

    @Inject protected ModelRemote remote;
    // todo: get data

    private int type;
    private List<NotificationInfoViewModel> notificationInfos;
    private List<NotificationViewModel> orderItems;

    public ListDataNotificationViewModel(int type, List<NotificationInfoViewModel> notificationInfos, List<NotificationViewModel> orderItems) {
        super(null);
        this.type = type;
        this.notificationInfos = notificationInfos;
        this.orderItems = orderItems;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<NotificationInfoViewModel> getNotificationInfos() {
        return notificationInfos;
    }

    public void setNotificationInfos(List<NotificationInfoViewModel> notificationInfos) {
        this.notificationInfos = notificationInfos;
    }

    public List<NotificationViewModel> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<NotificationViewModel> orderItems) {
        this.orderItems = orderItems;
    }
}
