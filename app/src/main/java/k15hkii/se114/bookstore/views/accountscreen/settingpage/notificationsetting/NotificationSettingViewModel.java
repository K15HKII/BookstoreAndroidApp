package k15hkii.se114.bookstore.views.accountscreen.settingpage.notificationsetting;

import androidx.databinding.Observable;
import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;

public class NotificationSettingViewModel extends BaseViewModel<NotificationSettingNavigator> implements Observable {
    public NotificationSettingViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    public void onMyOrderClick(){
        getNavigator().openMyOrderNotificaitionSetting();
    }

    public void onOtherNotificationClick(){
        getNavigator().openOtherNotificationSetting();
    }

    public void onVoucherNotificationClick(){
        getNavigator().openVoucherNotificationSetting();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
