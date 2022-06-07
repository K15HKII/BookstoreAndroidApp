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
        getCompositeDisposable().add(authentication.login(new LoginRequest(username.get(), password.get()))
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(io.reactivex.android.schedulers.AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    if (response.isAuthenticated())
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
