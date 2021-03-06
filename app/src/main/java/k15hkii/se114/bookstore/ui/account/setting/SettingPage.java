package k15hkii.se114.bookstore.ui.account.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.SettingPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.account.setting.languagesetting.LanguageSetting;
import k15hkii.se114.bookstore.ui.account.setting.notificationsetting.NotificationSetting;
import k15hkii.se114.bookstore.ui.account.setting.privacysetting.PrivacySetting;
import k15hkii.se114.bookstore.ui.base.BaseFragment;

public class SettingPage extends BaseFragment<SettingPageFragmentBinding, SettingPageViewModel> implements SettingPagenavigator {

    private SettingPageFragmentBinding settingPageFragmentBinding;

    @Override
    public int getBindingVariable() {
        return BR.SettingPageViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.setting_page_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        settingPageFragmentBinding = getViewDataBinding();
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
    public void openNotificationSetting() {
        createTransaction(R.id.fragmentContainerView, NotificationSetting.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openPrivacySetting() {
        createTransaction(R.id.fragmentContainerView, PrivacySetting.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openLanguageSetting() {
        createTransaction(R.id.fragmentContainerView, LanguageSetting.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

}
