package com.example.libraryapp;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
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
import com.example.libraryapp.ViewModel.LoginViewModel;

public class Login extends Fragment {

    private LoginViewModel mViewModel;
    private EditText etUsername,etPassword;
    private Button btnLogin, btnLoginWithGoogle, btnLoginWithFacebook;
    private TextView tvPassforget,tvRegister;
    private boolean passwordVisible;

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
        etUsername = view.findViewById(R.id.etLoginUser);
        etPassword = view.findViewById(R.id.etLoginPassword);
        btnLogin = view.findViewById(R.id.btnLoginLogin);
        btnLoginWithGoogle = view.findViewById(R.id.btnLoginLoginWithGoogle);
        btnLoginWithFacebook = view.findViewById(R.id.btnLoginLoginWithFaceBook);
        tvRegister = view.findViewById(R.id.tvLoginRegister);
        tvPassforget = view.findViewById(R.id.tvLoginPassforget);

//        Chức năng các nút
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction.replace(R.id.fragmentContainerView,rating_books_view.class,null).addToBackStack(null).commit();
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction.replace(R.id.fragmentContainerView,Register.class,null).addToBackStack(null).commit();
            }
        });

        tvPassforget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction.replace(R.id.fragmentContainerView,forgot_password.class,null).addToBackStack(null).commit();
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

        etPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right = 2;
                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    if(motionEvent.getRawX()>=etPassword.getRight()-etPassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = etPassword.getSelectionEnd();
                        if(passwordVisible){
                            //set drawable image here
                            etPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_visibility_off_black,0);
                            //for hide password
                            etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }
                        else{
                            //set drawable image here
                            etPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_visibility_black,0);
                            //for show password
                            etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        etPassword.setSelection(selection);
                        return true;
                    }
                }
                return false;
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
