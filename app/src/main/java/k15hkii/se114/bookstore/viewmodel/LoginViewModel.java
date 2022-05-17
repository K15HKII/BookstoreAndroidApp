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
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;
import k15hkii.se114.bookstore.views.loginscreen.Login;
import k15hkii.se114.bookstore.data.model.api.UserAccount;
import k15hkii.se114.bookstore.views.loginscreen.LoginNavigator;

import java.util.List;

public class LoginViewModel extends BaseViewModel<LoginNavigator> implements Observable {
    // TODO: Implement the ViewModel
    private String user;
    private String pass;

    private Authentication authentication;
    public ObservableField<String> LoginMessage = new ObservableField<>();
    private List<UserAccount> lsUsers;

    public LoginViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Bindable
    public String getUser() {
        return user;
    }

    @Bindable
    public String getPass() {
        return pass;
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
                    getNavigator().openHomeView();
                }, throwable -> {
                    getNavigator().handleError(throwable);
                });
    }

    public void onServerLoginClick() {
        getNavigator().login();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

}
