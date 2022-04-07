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
import com.example.libraryapp.ViewModel.ForgotPasswordViewModel;

public class forgot_password extends Fragment {

    private ForgotPasswordViewModel mViewModel;
    private Button btnNext, btnBackward;
    private TextView tvRegister;
    private EditText etRegister;

    public static forgot_password newInstance() {
        return new forgot_password();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.forgot_password_fragment, container, false);

        FragmentManager fragmentManager = forgot_password.this.getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        btnNext = view.findViewById(R.id.btnForgotPasswordNext);
        btnBackward = view.findViewById(R.id.btnForgotPasswordBackward);
        etRegister = view.findViewById(R.id.etForgotPasswordEmailorPhone);
        tvRegister = view.findViewById(R.id.tvForgotPasswordRegister);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnBackward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction.replace(R.id.fragmentContainerView,Register.class,null).addToBackStack(null).commit();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ForgotPasswordViewModel.class);
        // TODO: Use the ViewModel
    }

}