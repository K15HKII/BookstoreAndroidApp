package k15hkii.se114.bookstore.ui.accountscreen.settingpage;

import k15hkii.se114.bookstore.ui.base.INavigator;

public interface SettingPagenavigator extends INavigator {
    void BackWard();

    void openNotificationSetting();

    void openPrivacySetting();

    void openLanguageSetting();
}
