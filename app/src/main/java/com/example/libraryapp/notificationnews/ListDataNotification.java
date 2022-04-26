package com.example.libraryapp.notificationnews;

import java.util.List;

public class ListDataNotification {
    private int type;
    private List<NotificationInfo> notificationInfos;
    private List<NotificationOrderView> orderItems;

    public ListDataNotification(int type, List<NotificationInfo> notificationInfos, List<NotificationOrderView> orderItems) {
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

    public List<NotificationInfo> getNotificationInfos() {
        return notificationInfos;
    }

    public void setNotificationInfos(List<NotificationInfo> notificationInfos) {
        this.notificationInfos = notificationInfos;
    }

    public List<NotificationOrderView> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<NotificationOrderView> orderItems) {
        this.orderItems = orderItems;
    }
}
