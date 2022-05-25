package k15hkii.se114.bookstore.ui.accountscreen.settingpage.languagesetting;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.LanguageSettingFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;

public class LanguageSetting extends BaseFragment<LanguageSettingFragmentBinding, LanguageSettingViewModel> implements LanguageSettingNavigator {

    private LanguageSettingFragmentBinding languageSettingFragmentBinding;
    private LanguageSettingViewModel mViewModel;

    public static LanguageSetting newInstance() {
        return new LanguageSetting();
    }

    @Override
    public int getBindingVariable() {
        return BR.LanguageSettingViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.language_setting_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        languageSettingFragmentBinding = getViewDataBinding();
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
        mViewModel = new ViewModelProvider(this).get(LanguageSettingViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }
}
