package k15hkii.se114.bookstore.views.accountscreen.settingpage.notificationsetting;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.NotificationSettingFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.notificationsetting.myordernotification.MyOrderNotification;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.notificationsetting.othernotification.OtherNotification;
import k15hkii.se114.bookstore.views.accountscreen.settingpage.notificationsetting.vouchernotification.VoucherNotificaiton;

public class NotificationSetting extends BaseFragment<NotificationSettingFragmentBinding, NotificationSettingViewModel> implements NotificationSettingNavigator {

    private NotificationSettingFragmentBinding notificationSettingFragmentBinding;
    private NotificationSettingViewModel mViewModel;

    public static NotificationSetting newInstance() {
        return new NotificationSetting();
    }

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NotificationSettingViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }

    @Override
    public void openMyOrderNotificaitionSetting() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, MyOrderNotification.class, null).addToBackStack(null).commit();
    }

    @Override
    public void openOtherNotificationSetting() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, OtherNotification.class, null).addToBackStack(null).commit();
    }

    @Override
    public void openVoucherNotificationSetting() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, VoucherNotificaiton.class, null).addToBackStack(null).commit();
    }
}
