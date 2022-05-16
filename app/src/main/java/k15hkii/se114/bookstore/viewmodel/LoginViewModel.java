package k15hkii.se114.bookstore.viewmodel;

import android.annotation.SuppressLint;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.data.model.auth.LoginRequest;
import k15hkii.se114.bookstore.data.model.auth.LoginResponse;
import k15hkii.se114.bookstore.data.remote.Authentication;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;
import k15hkii.se114.bookstore.views.loginscreen.Login;
import k15hkii.se114.bookstore.data.model.api.UserAccount;

import java.util.List;

public class LoginViewModel extends BaseViewModel implements Observable {
    // TODO: Implement the ViewModel
    private String user;
    private String pass;

    private Authentication authentication;
    public ObservableField<String> LoginMessage = new ObservableField<>();
    private List<UserAccount> lsUsers;

    @Bindable
    public String getUser() {
        return user;
    }

    @SuppressLint("CheckResult")
    public void login() {
        Authentication authentication = null;

        authentication.login(new LoginRequest(user, pass))
                .doOnSuccess(response -> {

                })
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(io.reactivex.android.schedulers.AndroidSchedulers.mainThread())
                .subscribe(userAccount -> {
                    //TODO: chuyen trang
                }, throwable -> {
                });
    }

    public void abc(LoginResponse response) {

    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

}
