package k15hkii.se114.bookstore.views.accountscreen.settingpage.notificationsetting;

import k15hkii.se114.bookstore.viewmodel.base.INavigator;

public interface NotificationSettingNavigator extends INavigator {
    void BackWard();

    void openMyOrderNotificaitionSetting();

    void openOtherNotificationSetting();

    void openVoucherNotificationSetting();
}
