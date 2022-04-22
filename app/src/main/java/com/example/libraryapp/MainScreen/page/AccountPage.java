package com.example.libraryapp.MainScreen.page;

import android.os.Handler;
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
import com.example.libraryapp.LoginScreen.LoadingDialog;
import com.example.libraryapp.R;
import com.example.libraryapp.ViewModel.AccountViewViewModel;
import com.example.libraryapp.AccountScreen.AccountDetailPage;
import com.example.libraryapp.AccountScreen.HelpPage;
import com.example.libraryapp.AccountScreen.SettingPage;

public class AccountPage extends Fragment {

    private AccountViewViewModel mViewModel;
    private Button btnInfomation, btnSetting, btnHelpCenter;

    public static AccountPage newInstance() {
        return new AccountPage();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.account_page_fragment, container, false);

        btnInfomation = view.findViewById(R.id.btnAccountInfomation);
        btnSetting = view.findViewById(R.id.btnAccountSetting);
        btnHelpCenter = view.findViewById(R.id.btnAccountHelpCenter);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
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

        btnInfomation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction.replace(R.id.fragmentContainerView, AccountDetailPage.class,null).addToBackStack(null).commit();
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction.replace(R.id.fragmentContainerView, SettingPage.class,null).addToBackStack(null).commit();
            }
        });

        btnHelpCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction.replace(R.id.fragmentContainerView, HelpPage.class,null).addToBackStack(null).commit();
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
