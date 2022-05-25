package k15hkii.se114.bookstore.ui.accountscreen.settingpage.privacysetting;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.PrivacySettingFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;

public class PrivacySetting extends BaseFragment<PrivacySettingFragmentBinding, PrivacySettingViewModel> implements PrivacySettingNavigator {

    private PrivacySettingFragmentBinding privacySettingFragmentBinding;
    private PrivacySettingViewModel mViewModel;

    public static PrivacySetting newInstance() {
        return new PrivacySetting();
    }

    @Override
    public int getBindingVariable() {
        return BR.PrivacySettingViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.privacy_setting_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        privacySettingFragmentBinding = getViewDataBinding();
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
        mViewModel = new ViewModelProvider(this).get(PrivacySettingViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }
}
