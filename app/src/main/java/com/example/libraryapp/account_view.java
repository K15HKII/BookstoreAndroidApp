package com.example.libraryapp;

import android.widget.Button;
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
import com.example.libraryapp.ViewModel.AccountViewViewModel;

public class account_view extends Fragment {

    private AccountViewViewModel mViewModel;
    private Button btnInfomation, btnSetting, btnHelpCenter;

    public static account_view newInstance() {
        return new account_view();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.account_view_fragment, container, false);

        btnInfomation = view.findViewById(R.id.btnAccountInfomation);
        btnSetting = view.findViewById(R.id.btnAccountSetting);
        btnHelpCenter = view.findViewById(R.id.btnAccountHelpCenter);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        btnInfomation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction.replace(R.id.fragmentContainerView,account_info_view.class,null).addToBackStack(null).commit();
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction.replace(R.id.fragmentContainerView,setting_page.class,null).addToBackStack(null).commit();
            }
        });

        btnHelpCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction.replace(R.id.fragmentContainerView,help_page.class,null).addToBackStack(null).commit();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AccountViewViewModel.class);
        // TODO: Use the ViewModel
    }

}
