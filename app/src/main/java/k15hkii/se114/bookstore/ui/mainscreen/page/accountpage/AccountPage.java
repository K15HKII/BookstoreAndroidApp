package k15hkii.se114.bookstore.ui.mainscreen.page.accountpage;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.databinding.AccountPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.ui.accountscreen.accountinfopage.AccountInfoPage;
import k15hkii.se114.bookstore.ui.accountscreen.helppage.HelpPage;
import k15hkii.se114.bookstore.ui.accountscreen.settingpage.SettingPage;
import k15hkii.se114.bookstore.ui.accountscreen.voucherscreen.VoucherPage;
import k15hkii.se114.bookstore.ui.dialog.logout.LogOutDialog;

public class AccountPage extends BaseFragment<AccountPageFragmentBinding, AccountPageViewModel> implements AccountPageNavigator {

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.account_page_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        AccountPageFragmentBinding accountPageFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);
        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void openAccountInfo() {
        createTransaction(R.id.fragmentContainerView, AccountInfoPage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openVoucher() {
        createTransaction(R.id.fragmentContainerView, VoucherPage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openSetting() {
        createTransaction(R.id.fragmentContainerView, SettingPage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openHelpPage() {
        createTransaction(R.id.fragmentContainerView, HelpPage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void logOut() {
        LogOutDialog.newInstance().show(getActivity().getSupportFragmentManager());
    }
}
