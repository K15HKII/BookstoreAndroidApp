package com.example.libraryapp.AccountScreen;

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
import androidx.fragment.app.Fragment;
import com.example.libraryapp.R;
import com.example.libraryapp.ViewModel.AccountInfoViewViewModel;

public class AccountDetailPage extends Fragment {

    private AccountInfoViewViewModel mViewModel;
    private LinearLayout btnChangeName, btnPasswordChange;

    public static AccountDetailPage newInstance() {
        return new AccountDetailPage();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.account_detail_page_fragment, container, false);
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
        etNewPassConfirm = dialog.findViewById(R.id.etChangePassConfirmPass);
        btnChangePass = dialog.findViewById(R.id.btnChangePassChangePassword);

        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
