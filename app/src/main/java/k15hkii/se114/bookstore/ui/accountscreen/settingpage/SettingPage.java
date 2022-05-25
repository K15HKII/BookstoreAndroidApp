package k15hkii.se114.bookstore.ui.accountscreen.settingpage;

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
import k15hkii.se114.bookstore.databinding.SettingPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.accountscreen.settingpage.languagesetting.LanguageSetting;
import k15hkii.se114.bookstore.ui.accountscreen.settingpage.notificationsetting.NotificationSetting;
import k15hkii.se114.bookstore.ui.accountscreen.settingpage.privacysetting.PrivacySetting;

public class SettingPage extends BaseFragment<SettingPageFragmentBinding, SettingPageViewModel> implements SettingPagenavigator {

    private SettingPageFragmentBinding settingPageFragmentBinding;
    private SettingPageViewModel mViewModel;

    public static SettingPage newInstance() {
        return new SettingPage();
    }

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SettingPageViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }

    @Override
    public void openNotificationSetting() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,   // popEnter
                R.anim.slide_out  // popExit
        ).replace(R.id.fragmentContainerView, NotificationSetting.class, null).addToBackStack(null).commit();
    }

    @Override
    public void openPrivacySetting() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,   // popEnter
                R.anim.slide_out  // popExit
        ).replace(R.id.fragmentContainerView, PrivacySetting.class, null).addToBackStack(null).commit();
    }

    @Override
    public void openLanguageSetting() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,   // popEnter
                R.anim.slide_out  // popExit
        ).replace(R.id.fragmentContainerView, LanguageSetting.class, null).addToBackStack(null).commit();
    }
}
