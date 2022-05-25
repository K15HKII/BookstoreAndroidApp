package k15hkii.se114.bookstore.views.loginscreen;

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

    private String user;
    private String pass;

    private final Authentication authentication;
    public ObservableField<String> LoginMessage = new ObservableField<>();
    private List<UserAccount> lsUsers;

    public LoginViewModel(SchedulerProvider schedulerProvider, Authentication authentication) {
        super(schedulerProvider);
        this.authentication = authentication;
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

    public void login(Object obj) {
        getCompositeDisposable().add(authentication.login(new LoginRequest(user, pass))
                .doOnSuccess(response -> {
                    System.out.println(response.toString());
                })
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(io.reactivex.android.schedulers.AndroidSchedulers.mainThread())
                .subscribe(userAccount -> {
                    getNavigator().openHomeView(obj);
                }, throwable -> {
                    getNavigator().handleError(throwable);
                }));
    }

    public void onServerLoginClick() {
        login(null);
//        getNavigator().openHomeView();
    }

    public void onForgotPasswordClick() {
        getNavigator().openPasswordForget();
    }

    public void onRegisterClick() {
        getNavigator().openRegister();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

}
