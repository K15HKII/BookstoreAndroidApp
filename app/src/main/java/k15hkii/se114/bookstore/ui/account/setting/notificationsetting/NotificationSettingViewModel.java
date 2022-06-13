package k15hkii.se114.bookstore.ui.account.setting.notificationsetting;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class NotificationSettingViewModel extends BaseViewModel<NotificationSettingNavigator> implements Observable {

    public NotificationSettingViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

    public void onMyOrderClick() {
        getNavigator().openMyOrderNotificaitionSetting();
    }

    public void onOtherNotificationClick() {
        getNavigator().openOtherNotificationSetting();
    }

    public void onVoucherNotificationClick() {
        getNavigator().openVoucherNotificationSetting();
    }

}
