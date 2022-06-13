package k15hkii.se114.bookstore.ui.account.help;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.HelpPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.account.help.delete.DeleteAccount;
import k15hkii.se114.bookstore.ui.account.help.helpcenter.HelpCenter;
import k15hkii.se114.bookstore.ui.account.help.introduction.Introduction;
import k15hkii.se114.bookstore.ui.account.help.policy.Policy;
import k15hkii.se114.bookstore.ui.base.BaseFragment;

public class HelpPage extends BaseFragment<HelpPageFragmentBinding, HelpPageViewModel> implements HelpPageNavigator {

    private HelpPageFragmentBinding helpPageFragmentBinding;

    @Override
    public int getBindingVariable() {
        return BR.HelpPageViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.help_page_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        helpPageFragmentBinding = getViewDataBinding();
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
    public void openHelpCenter() {
        createTransaction(R.id.fragmentContainerView, HelpCenter.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openAppIntroduction() {
        createTransaction(R.id.fragmentContainerView, Introduction.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openPolicy() {
        createTransaction(R.id.fragmentContainerView, Policy.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openDeleteAccountRequest() {
        createTransaction(R.id.fragmentContainerView, DeleteAccount.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

}
