package k15hkii.se114.bookstore.ui.accountscreen.accountinfopage;

import android.view.*;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.AccountInfoPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.address.SelectorAddressPage;
import k15hkii.se114.bookstore.ui.bankscreen.SelectorBankPage;
import k15hkii.se114.bookstore.ui.components.CloseReturnCallback;
import k15hkii.se114.bookstore.ui.dialog.changebirth.ChangeBirthDialog;
import k15hkii.se114.bookstore.ui.dialog.changegender.ChangeGenderDialog;
import k15hkii.se114.bookstore.ui.dialog.changename.ChangeNameDialog;
import k15hkii.se114.bookstore.ui.dialog.changepassword.ChangePassDialog;
import k15hkii.se114.bookstore.ui.dialog.changephone.ChangePhoneNumDialog;

public class AccountInfoPage extends BaseFragment<AccountInfoPageFragmentBinding, AccountInfoViewViewModel> implements AccountInfoNavigator {

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.account_info_page_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        viewModel.setNavigator(this);
        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void backward() {
        getFragmentManager().popBackStack();
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
