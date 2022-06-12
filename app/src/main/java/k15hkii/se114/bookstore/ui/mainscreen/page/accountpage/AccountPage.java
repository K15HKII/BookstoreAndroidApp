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
import k15hkii.se114.bookstore.ui.address.SelectorAddressPage;
import k15hkii.se114.bookstore.ui.bankscreen.SelectorBankPage;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.ui.accountscreen.accountinfopage.AccountInfoPage;
import k15hkii.se114.bookstore.ui.accountscreen.helppage.HelpPage;
import k15hkii.se114.bookstore.ui.accountscreen.settingpage.SettingPage;
import k15hkii.se114.bookstore.ui.accountscreen.voucherscreen.VoucherPage;
import k15hkii.se114.bookstore.ui.dialog.changebirth.ChangeBirthDialog;
import k15hkii.se114.bookstore.ui.dialog.changename.ChangeNameDialog;
import k15hkii.se114.bookstore.ui.dialog.changegender.ChangeGenderDialog;
import k15hkii.se114.bookstore.ui.dialog.changepassword.ChangePassDialog;
import k15hkii.se114.bookstore.ui.dialog.changephone.ChangePhoneNumDialog;
import k15hkii.se114.bookstore.ui.dialog.logout.LogOutDialog;
import k15hkii.se114.bookstore.ui.mainscreen.page.favoritepage.FavoritePage;
import k15hkii.se114.bookstore.ui.mainscreen.page.rentpage.RentPage;
import k15hkii.se114.bookstore.ui.mainscreen.page.shippingpage.ShippingPage;

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
        AccountPageFragmentBinding binding = getViewDataBinding();
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
    public void openFavoritePage() {
        createTransaction(R.id.fragmentContainerView, FavoritePage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openOrder() {
        createTransaction(R.id.fragmentContainerView, ShippingPage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openRent() {
        createTransaction(R.id.fragmentContainerView, RentPage.class, null)
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

    @Override
    public void openChangeNameDialog() {
        ChangeNameDialog.newInstance().show(getActivity().getSupportFragmentManager());
    }

    @Override
    public void openChangePasswordDialog() {
        ChangePassDialog.newInstance().show(getActivity().getSupportFragmentManager());
    }

    @Override
    public void openChangePhoneNumDialog() {
        ChangePhoneNumDialog.newInstance().show(getActivity().getSupportFragmentManager());
    }

    @Override
    public void openChangeGenderDialog() {
        ChangeGenderDialog.newInstance().show(getActivity().getSupportFragmentManager());
    }

    @Override
    public void openChangeBirthDialog() {
        ChangeBirthDialog.newInstance().show(getActivity().getSupportFragmentManager());
    }

    @Override
    public void openSelectAddress() {
        createTransaction(R.id.fragmentContainerView, SelectorAddressPage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openSelectBank() {
        createTransaction(R.id.fragmentContainerView, SelectorBankPage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }
}
