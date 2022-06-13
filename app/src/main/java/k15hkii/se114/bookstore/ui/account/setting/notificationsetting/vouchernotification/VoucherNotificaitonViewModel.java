package k15hkii.se114.bookstore.ui.account.setting.notificationsetting.vouchernotification;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class VoucherNotificaitonViewModel extends BaseViewModel<VoucherNotificaitonNavigator> implements Observable {

    public VoucherNotificaitonViewModel(SchedulerProvider schedulerProvider) {
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
