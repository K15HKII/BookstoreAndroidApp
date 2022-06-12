package k15hkii.se114.bookstore.ui.loginscreen;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.auth.LoginRequest;
import k15hkii.se114.bookstore.data.remote.Authentication;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class LoginViewModel extends BaseViewModel<LoginNavigator> implements Observable {

    public final ObservableField<String> username = new ObservableField<>();
    public final ObservableField<String> password = new ObservableField<>();

    private final Authentication authentication;
    public ObservableField<String> LoginMessage = new ObservableField<>();

    public LoginViewModel(SchedulerProvider schedulerProvider, Authentication authentication) {
        super(schedulerProvider);
        this.authentication = authentication;
    }

    public void login(Object obj) {
        dispose(authentication.login(new LoginRequest(username.get(), password.get())),
                response -> {
                    if (response.isAuthenticated())
                        getNavigator().openHomeView(obj);
                }, throwable -> {
                    getNavigator().handleError(throwable);
                });
    }

    public void onServerLoginClick() {
        login(null);
    }

    public void onForgotPasswordClick() {
        getNavigator().openPasswordForget();
    }

    public void onRegisterClick() {
        getNavigator().openRegister();
    }

}
