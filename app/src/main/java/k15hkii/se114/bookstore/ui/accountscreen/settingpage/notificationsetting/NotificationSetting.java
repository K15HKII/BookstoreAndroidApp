package k15hkii.se114.bookstore.ui.accountscreen.settingpage.notificationsetting;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.NotificationSettingFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.address.SelectorAddressPage;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.accountscreen.settingpage.notificationsetting.myordernotification.MyOrderNotification;
import k15hkii.se114.bookstore.ui.accountscreen.settingpage.notificationsetting.othernotification.OtherNotification;
import k15hkii.se114.bookstore.ui.accountscreen.settingpage.notificationsetting.vouchernotification.VoucherNotificaiton;

public class NotificationSetting extends BaseFragment<NotificationSettingFragmentBinding, NotificationSettingViewModel> implements NotificationSettingNavigator {

    private NotificationSettingFragmentBinding notificationSettingFragmentBinding;

    @Override
    public int getBindingVariable() {
        return BR.NotificationSettingViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.notification_setting_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        notificationSettingFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);
        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }

    @Override
    public void openMyOrderNotificaitionSetting() {
        createTransaction(R.id.fragmentContainerView, MyOrderNotification.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openOtherNotificationSetting() {
        createTransaction(R.id.fragmentContainerView, OtherNotification.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openVoucherNotificationSetting() {
        createTransaction(R.id.fragmentContainerView, VoucherNotificaiton.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }
}
