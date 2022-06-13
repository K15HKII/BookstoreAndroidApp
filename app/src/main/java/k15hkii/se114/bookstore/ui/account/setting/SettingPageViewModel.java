package k15hkii.se114.bookstore.ui.account.setting;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class SettingPageViewModel extends BaseViewModel<SettingPagenavigator> implements Observable {

    public SettingPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void changeTheme() {

    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

    public void onNotificationSettingClick() {
        getNavigator().openNotificationSetting();
    }

    public void onPrivacySettingClick() {
        getNavigator().openPrivacySetting();
    }

    public void onLanguageSettingClick() {
        getNavigator().openLanguageSetting();
    }

}
