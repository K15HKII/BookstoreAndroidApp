package k15hkii.se114.bookstore.ui.mainscreen.page.accountpage;

import android.widget.Button;
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
import k15hkii.se114.bookstore.data.model.api.User;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.databinding.AccountPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.ui.accountscreen.accountinfopage.AccountInfoPage;
import k15hkii.se114.bookstore.ui.accountscreen.helppage.HelpPage;
import k15hkii.se114.bookstore.ui.accountscreen.settingpage.SettingPage;
import k15hkii.se114.bookstore.ui.accountscreen.voucherscreen.VoucherPage;
import k15hkii.se114.bookstore.ui.dialog.logout.LogOutDialog;

import javax.inject.Inject;

public class AccountPage extends BaseFragment<AccountPageFragmentBinding, AccountPageViewModel> implements AccountPageNavigator {

    private AccountPageFragmentBinding accountPageFragmentBinding;

    private Button btnInfomation, btnSetting, btnHelpCenter;



    public static AccountPage newInstance() {
        return new AccountPage();
    }

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
        accountPageFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

//        final LoadingDialog loadingDialog = new LoadingDialog(getActivity());
//        loadingDialog.startLoadingDialog();
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                loadingDialog.dismissDialog();
//            }
//        },1000);

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void openAccountInfo() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,   // popEnter
                R.anim.slide_out  // popExit
        ).replace(R.id.fragmentContainerView, AccountInfoPage.class,null).addToBackStack(null).commit();
    }

    @Override
    public void openVoucher() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,   // popEnter
                R.anim.slide_out  // popExit
        ).replace(R.id.fragmentContainerView, VoucherPage.class,null).addToBackStack(null).commit();
    }

    @Override
    public void openSetting() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,   // popEnter
                R.anim.slide_out  // popExit
        ).replace(R.id.fragmentContainerView, SettingPage.class,null).addToBackStack(null).commit();
    }

    @Override
    public void openHelpPage() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,   // popEnter
                R.anim.slide_out  // popExit
        ).replace(R.id.fragmentContainerView, HelpPage.class,null).addToBackStack(null).commit();
    }

    @Override
    public void logOut() {
        LogOutDialog.newInstance().show(getActivity().getSupportFragmentManager());
    }
}
