package k15hkii.se114.bookstore.views.accountscreen.helppage.helpcenter;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.HelpCenterFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;

public class HelpCenter extends BaseFragment<HelpCenterFragmentBinding, HelpCenterViewModel> implements HelpCenterNavigator {

    private HelpCenterFragmentBinding helpCenterFragmentBinding;
    private HelpCenterViewModel mViewModel;

    public static HelpCenter newInstance() {
        return new HelpCenter();
    }

    @Override
    public int getBindingVariable() {
        return BR.HelpCenterPageViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.help_center_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        helpCenterFragmentBinding = getViewDataBinding();
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
        mViewModel = new ViewModelProvider(this).get(HelpCenterViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }
}
