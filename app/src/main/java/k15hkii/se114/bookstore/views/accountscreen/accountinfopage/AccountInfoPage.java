package k15hkii.se114.bookstore.views.accountscreen.accountinfopage;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.AccountInfoPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;

public class AccountInfoPage extends BaseFragment<AccountInfoPageFragmentBinding, AccountInfoViewViewModel> implements AccountInfoNavigator {

    private AccountInfoPageFragmentBinding accountInfoPageFragmentBinding;
    private AccountInfoViewViewModel mViewModel;
    private LinearLayout btnChangeName, btnPasswordChange;

    public static AccountInfoPage newInstance() {
        return new AccountInfoPage();
    }

    @Override
    public int getBindingVariable() {
        return BR.AccountInfoViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.account_info_page_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        accountInfoPageFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        btnChangeName = view.findViewById(R.id.btnAccountInfoDetailName);
        btnPasswordChange = view.findViewById(R.id.btnAccountInfoPasswordChange);

        btnChangeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChangeName(Gravity.CENTER);
            }
        });

        btnPasswordChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChangePassword(Gravity.CENTER);
            }
        });

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AccountInfoViewViewModel.class);
        // TODO: Use the ViewModel
    }

    private void openChangeName(int gravity){
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.change_name_dialog);

        Window window = dialog.getWindow();
        if(window == null){
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAtributes = window.getAttributes();
        windowAtributes.gravity = gravity;
        window.setAttributes(windowAtributes);

        if(Gravity.CENTER == gravity);
        {
            dialog.setCancelable(true);
        }

        EditText etChangeName = dialog.findViewById(R.id.etChangeNameName);
        Button btnChangeName = dialog.findViewById(R.id.btnChangeNameChangeName);

        btnChangeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void openChangePassword(int gravity){
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.change_password_dialog);

        Window window = dialog.getWindow();
        if(window == null){
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAtributes = window.getAttributes();
        windowAtributes.gravity = gravity;
        window.setAttributes(windowAtributes);

        if(Gravity.CENTER == gravity);
        {
            dialog.setCancelable(true);
        }

        EditText etOldPass, etNewPass, etNewPassConfirm;
        Button btnChangePass;

        etOldPass = dialog.findViewById(R.id.etChangePassOldPass);
        etNewPass = dialog.findViewById(R.id.etChangePassNewPass);
        etNewPassConfirm = dialog.findViewById(R.id.etChangePassConfirmNewPass);
        btnChangePass = dialog.findViewById(R.id.btnChangePassConfirmChange);

        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }
}
