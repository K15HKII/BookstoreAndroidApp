package k15hkii.se114.bookstore.views.accountscreen.settingpage.notificationsetting;

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

}
