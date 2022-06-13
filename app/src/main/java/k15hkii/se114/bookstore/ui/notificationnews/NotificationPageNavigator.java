package k15hkii.se114.bookstore.ui.notificationnews;

import k15hkii.se114.bookstore.ui.base.INavigator;

public interface NotificationPageNavigator extends INavigator {
    void BackWard();

    void openVoucherPage();

    void childNavigate(Object object);
}
