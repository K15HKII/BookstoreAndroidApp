package k15hkii.se114.bookstore.ui.accountscreen.accountinfopage;

import android.view.*;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.AccountInfoPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.address.SelectorAddressPage;
import k15hkii.se114.bookstore.ui.bankscreen.SelectorBankPage;
import k15hkii.se114.bookstore.ui.dialog.changebirth.ChangeBirthDialog;
import k15hkii.se114.bookstore.ui.dialog.changegender.ChangeGenderDialog;
import k15hkii.se114.bookstore.ui.dialog.changename.ChangeNameDialog;
import k15hkii.se114.bookstore.ui.dialog.changepassword.ChangePassDialog;
import k15hkii.se114.bookstore.ui.dialog.changephone.ChangePhoneNumDialog;

public class AccountInfoPage extends BaseFragment<AccountInfoPageFragmentBinding, AccountInfoViewViewModel> implements AccountInfoNavigator {

    public static AccountInfoPage newInstance() {
        return new AccountInfoPage();
    }

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
        AccountInfoPageFragmentBinding accountInfoPageFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

//    private void openChangeName(int gravity){
//        final Dialog dialog = new Dialog(getActivity());
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.change_name_dialog);
//
//        Window window = dialog.getWindow();
//        if(window == null){
//            return;
//        }
//
//        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
//        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//        WindowManager.LayoutParams windowAtributes = window.getAttributes();
//        windowAtributes.gravity = gravity;
//        window.setAttributes(windowAtributes);
//
//        if(Gravity.CENTER == gravity);
//        {
//            dialog.setCancelable(true);
//        }
//
//        EditText etChangeName = dialog.findViewById(R.id.etChangeNameName);
//        Button btnChangeName = dialog.findViewById(R.id.btnChangeNameChangeConfirm);
//
//        btnChangeName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//    }
//
//    private void openChangePassword(int gravity){
//        final Dialog dialog = new Dialog(getActivity());
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.change_password_dialog);
//
//        Window window = dialog.getWindow();
//        if(window == null){
//            return;
//        }
//
//        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
//        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//        WindowManager.LayoutParams windowAtributes = window.getAttributes();
//        windowAtributes.gravity = gravity;
//        window.setAttributes(windowAtributes);
//
//        if(Gravity.CENTER == gravity);
//        {
//            dialog.setCancelable(true);
//        }
//
//        EditText etOldPass, etNewPass, etNewPassConfirm;
//        Button btnChangePass;
//
//        etOldPass = dialog.findViewById(R.id.etChangePassOldPass);
//        etNewPass = dialog.findViewById(R.id.etChangePassNewPass);
//        etNewPassConfirm = dialog.findViewById(R.id.etChangePassConfirmNewPass);
//        btnChangePass = dialog.findViewById(R.id.btnChangePassConfirmChange);
//
//        btnChangePass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
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
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,   // popEnter
                R.anim.slide_out  // popExit
        ).replace(R.id.fragmentContainerView, SelectorAddressPage.class, null).addToBackStack(null).commit();
    }

    @Override
    public void openSelectBank() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,   // popEnter
                R.anim.slide_out  // popExit
        ).replace(R.id.fragmentContainerView, SelectorBankPage.class, null).addToBackStack(null).commit();
    }


}
