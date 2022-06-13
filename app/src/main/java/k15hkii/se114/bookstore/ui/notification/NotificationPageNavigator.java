package k15hkii.se114.bookstore.ui.notification;

import k15hkii.se114.bookstore.ui.base.INavigator;

public interface NotificationPageNavigator extends INavigator {

    void BackWard();

    void openVoucherPage();

    void childNavigate(Object object);

}
