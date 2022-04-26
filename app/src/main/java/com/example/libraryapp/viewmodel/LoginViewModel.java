package com.example.libraryapp.viewmodel;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.libraryapp.BR;
import com.example.libraryapp.MainActivity;
import com.example.libraryapp.R;
import com.example.libraryapp.loginscreen.LoadingDialog;
import com.example.libraryapp.loginscreen.Login;
import com.example.libraryapp.mainscreen.HomeLayout;
import com.example.libraryapp.model.UserAccount;

import java.util.ArrayList;
import java.util.List;

public class LoginViewModel extends BaseObservable {
    // TODO: Implement the ViewModel
    private String user;
    private String pass;
    private Login loginView;
    public ObservableField<String> LoginMessage = new ObservableField<>();
    private List<UserAccount> lsUsers;

    public LoginViewModel(Login loginView) {
        this.loginView = loginView;
    }

    @Bindable
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
        notifyPropertyChanged(BR.user);
    }

    @Bindable
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
        notifyPropertyChanged(BR.pass);
    }

    boolean CheckUser(List<UserAccount> lsUsers,String user, String pass){
        for(int i=0;i<lsUsers.size();i++){
            String users = lsUsers.get(i).getUserName();
            String passs = lsUsers.get(i).getPassword();
            if(users.equals(user) && passs.equals(pass))
                return true;
        }
        return false;
    }

    public void LoginOnclick(){
        lsUsers = new ArrayList<>();
        lsUsers.add(new UserAccount("trihuu14","12345678"));
        lsUsers.add(new UserAccount("trihuu15","12345678"));
        lsUsers.add(new UserAccount("1", "1"));

        UserAccount userAccount = new UserAccount(getUser(),getPass());
        Context context = loginView.getContext();
        if(userAccount.isValidUserName() && userAccount.isValidPassword() && CheckUser(lsUsers, userAccount.getUserName(), userAccount.getPassword())){
            LoginMessage.set("Đăng nhập thành công");
//            FragmentManager fragmentManager = loginView.getChildFragmentManager();
//            Log.i("fuck huy", loginView.getActivity().hashCode() + "");
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            /*final LoadingDialog loadingDialog = new LoadingDialog(loginView);
            loadingDialog.startLoadingDialog();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    loadingDialog.dismissDialog();
                }
            },1000);*/
            Toast.makeText(context, "Đăng nhập thành công",Toast.LENGTH_SHORT).show();

            //fragmentTransaction.replace(R.id.fragmentContainerView, HomeLayout.class,null).addToBackStack(null).commit();
//            ((MainActivity) loginView.getActivity()).nav(HomeLayout.class);
        }else if (userAccount.isValidUserName() && userAccount.isValidPassword() && !CheckUser(lsUsers, userAccount.getUserName(), userAccount.getPassword())) {
            LoginMessage.set("Tài khoản hoặc mật khẩu sai!");
            Toast.makeText(context, "Đăng nhập không thành công",Toast.LENGTH_SHORT).show();
        }
        else{
            LoginMessage.set("Tài khoản hoặc mật khẩu không hợp lệ!");
            Toast.makeText(context, "Tài khoản không hợp lệ!",Toast.LENGTH_SHORT).show();
        }
    }
}
