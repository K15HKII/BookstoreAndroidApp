package k15hkii.se114.bookstore.ui.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.AccountPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.account.address.SelectorAddressPage;
import k15hkii.se114.bookstore.ui.account.bank.SelectorBankPage;
import k15hkii.se114.bookstore.ui.account.help.HelpPage;
import k15hkii.se114.bookstore.ui.account.setting.SettingPage;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.components.CloseReturnCallback;
import k15hkii.se114.bookstore.ui.dialog.changebirth.ChangeBirthDialog;
import k15hkii.se114.bookstore.ui.dialog.changegender.ChangeGenderDialog;
import k15hkii.se114.bookstore.ui.dialog.changename.ChangeNameDialog;
import k15hkii.se114.bookstore.ui.dialog.changepassword.ChangePassDialog;
import k15hkii.se114.bookstore.ui.dialog.changephone.ChangePhoneNumDialog;
import k15hkii.se114.bookstore.ui.dialog.logout.LogOutDialog;
import k15hkii.se114.bookstore.ui.mainscreen.page.favoritepage.FavoritePage;
import k15hkii.se114.bookstore.ui.mainscreen.page.recentbook.RecentListBook;
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
    public void openWaitingOrder() {
        Bundle bundle = new Bundle();
        bundle.putInt("position", 0);
        createTransaction(R.id.fragmentContainerView, ShippingPage.class, bundle)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openArrivedOrder() {
        Bundle bundle = new Bundle();
        bundle.putInt("position", 2);
        createTransaction(R.id.fragmentContainerView, ShippingPage.class, bundle)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openCancleOrder() {
        Bundle bundle = new Bundle();
        bundle.putInt("position", 3);
        createTransaction(R.id.fragmentContainerView, ShippingPage.class, bundle)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openShippingOrder() {
        Bundle bundle = new Bundle();
        bundle.putInt("position", 1);
        createTransaction(R.id.fragmentContainerView, ShippingPage.class, bundle)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openRenting() {
        Bundle bundle = new Bundle();
        bundle.putInt("position", 0);
        createTransaction(R.id.fragmentContainerView, RentPage.class, bundle)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openRented() {
        Bundle bundle = new Bundle();
        bundle.putInt("position", 1);
        createTransaction(R.id.fragmentContainerView, RentPage.class, bundle)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openRencentBook() {
        createTransaction(R.id.fragmentContainerView, RecentListBook.class, null)
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

    private final CloseReturnCallback closeCallback = new CloseReturnCallback() {
        @Override
        public void onClose(Object data) {
            viewModel.from(null);
        }
    };

    @Override
    public void openChangeNameDialog() {
        ChangeNameDialog.newInstance(closeCallback).show(getActivity().getSupportFragmentManager());
    }

    @Override
    public void openChangePasswordDialog() {
        ChangePassDialog.newInstance(closeCallback).show(getActivity().getSupportFragmentManager());
    }

    @Override
    public void openChangePhoneNumDialog() {
        ChangePhoneNumDialog.newInstance(closeCallback).show(getActivity().getSupportFragmentManager());
    }

    @Override
    public void openChangeGenderDialog() {
        ChangeGenderDialog.newInstance(closeCallback).show(getActivity().getSupportFragmentManager());
    }

    @Override
    public void openChangeBirthDialog() {
        ChangeBirthDialog.newInstance(closeCallback).show(getActivity().getSupportFragmentManager());
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
