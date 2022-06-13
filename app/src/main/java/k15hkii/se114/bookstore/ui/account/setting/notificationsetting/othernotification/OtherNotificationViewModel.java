package k15hkii.se114.bookstore.ui.account.setting.notificationsetting.othernotification;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class OtherNotificationViewModel extends BaseViewModel<OtherNotificationNavigator> implements Observable {

    public OtherNotificationViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void SoundPermission() {
    }

    public void ShakePermisstion() {
    }

    public void LightPermisstion() {
    }

    public void EmailPermission() {
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

}
