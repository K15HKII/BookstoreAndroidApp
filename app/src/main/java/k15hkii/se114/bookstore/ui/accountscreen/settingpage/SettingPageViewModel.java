package k15hkii.se114.bookstore.ui.accountscreen.settingpage;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

public class SettingPageViewModel extends BaseViewModel<SettingPagenavigator> implements Observable {
    public SettingPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void changeTheme(){

    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    public void onNotificationSettingClick(){
        getNavigator().openNotificationSetting();
    }

    public void onPrivacySettingClick(){
        getNavigator().openPrivacySetting();
    }

    public void onLanguageSettingClick(){
        getNavigator().openLanguageSetting();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
