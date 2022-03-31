package com.example.libraryapp;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Login extends Fragment {

    private LoginViewModel mViewModel;
    private EditText et_Username,et_Password;
    private Button btn_Login;
    private TextView tv_Passforget,tv_Register;

    public static Login newInstance() {
        return new Login();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        FragmentManager fragmentManager = Login.this.getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

//        Tìm view
        et_Username = view.findViewById(R.id.et_Login_User);
        et_Password = view.findViewById(R.id.et_Login_Password);
        btn_Login = view.findViewById(R.id.btn_Login_Login);
        tv_Register = view.findViewById(R.id.tv_Login_Register);
        tv_Passforget = view.findViewById(R.id.tv_Login_Passforget);

//        Chức năng các nút
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        tv_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction.replace(R.id.fragmentContainerView,Register.class,null).commit();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        // TODO: Use the ViewModel
    }

}