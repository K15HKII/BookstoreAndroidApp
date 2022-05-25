package k15hkii.se114.bookstore.ui.accountscreen.settingpage.notificationsetting;

import k15hkii.se114.bookstore.ui.base.INavigator;

public interface NotificationSettingNavigator extends INavigator {
    void BackWard();

    void openMyOrderNotificaitionSetting();

    void openOtherNotificationSetting();

    void openVoucherNotificationSetting();
}
