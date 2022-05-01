package com.example.libraryapp.loginscreen;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.libraryapp.mainscreen.HomeLayout;
import com.example.libraryapp.R;
import com.example.libraryapp.registerscreen.Register;
import com.example.libraryapp.viewmodel.LoginViewModel;
import com.example.libraryapp.forgotpassscreen.Forgot_password_page;
//import com.example.libraryapp.databinding.LoginFragmentBinding;

public class Login extends Fragment {

    private LoginViewModel loginViewModel;
    private EditText etUsername,etPassword;
    private Button btnLogin, btnLoginWithGoogle, btnLoginWithFacebook;
    private TextView tvPassforget,tvRegister;
    private boolean passwordVisible;

    public static Login newInstance() {
        return new Login();
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        FragmentManager fragmentManager = Login.this.getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

//        LoginFragmentBinding loginFragmentBinding = DataBindingUtil.setContentView(getActivity(), R.layout.login_fragment);
//        loginViewModel = new LoginViewModel(this);
//        loginFragmentBinding.setLoginViewModel(loginViewModel);
//        Tìm view
        etUsername = view.findViewById(R.id.etLoginUser);
        etPassword = view.findViewById(R.id.etLoginPassword);
        btnLogin = view.findViewById(R.id.btnLoginLogin);
        btnLoginWithGoogle = view.findViewById(R.id.btnLoginLoginWithGoogle);
        btnLoginWithFacebook = view.findViewById(R.id.btnLoginLoginWithFaceBook);
        tvRegister = view.findViewById(R.id.tvLoginRegister);
        tvPassforget = view.findViewById(R.id.tvLoginPassforget);
        final LoadingDialog loadingDialog = new LoadingDialog(getActivity());

//        Chức năng các nút

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final LoadingDialog loadingDialog = new LoadingDialog(getActivity());
                loadingDialog.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadingDialog.dismissDialog();
                    }
                },500);
                Toast.makeText(getContext(), "Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                fragmentTransaction.replace(R.id.fragmentContainerView, HomeLayout.class,null).addToBackStack(null).commit();
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                fragmentTransaction.replace(R.id.fragmentContainerView, Register.class,null).addToBackStack(null).commit();
            }
        });

        tvPassforget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                fragmentTransaction.replace(R.id.fragmentContainerView, Forgot_password_page.class,null).addToBackStack(null).commit();
            }
        });

        btnLoginWithGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnLoginWithFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }

    public void LoginSucess(){
        FragmentManager fragmentManager = Login.this.getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            final LoadingDialog loadingDialog = new LoadingDialog(getActivity());
            loadingDialog.startLoadingDialog();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    loadingDialog.dismissDialog();
                }
            },1000);
            Toast.makeText(getContext(), "Đăng nhập thành công",Toast.LENGTH_SHORT).show();
            fragmentTransaction.replace(R.id.fragmentContainerView, HomeLayout.class,null).addToBackStack(null).commit();
    }
    public void LoginFailed(){
        Toast.makeText(getContext(), "Đăng nhập không thành công",Toast.LENGTH_SHORT).show();
    }

}
