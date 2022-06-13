package k15hkii.se114.bookstore.ui.loginscreen;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.Constant;
import k15hkii.se114.bookstore.data.model.auth.LoginRequest;
import k15hkii.se114.bookstore.data.remote.Authentication;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class LoginViewModel extends BaseViewModel<LoginNavigator> implements Observable {

    public final ObservableField<String> username = new ObservableField<>("");
    public final ObservableField<String> password = new ObservableField<>("");

    private final Authentication authentication;
    public ObservableField<String> LoginMessage = new ObservableField<>();

    public LoginViewModel(SchedulerProvider schedulerProvider, Authentication authentication) {
        super(schedulerProvider);
        this.authentication = authentication;
    }

    //TODO:THIẾU ĐĂNG NHẬP BẰNG GOOGLE
    public void login(Object obj) {
        int statuscode = -1;
        //KIỂM TRA CÓ NHẬP THÔNG TIN HAY CHƯA
        if(username.get().isEmpty() || password.get().isEmpty()) {
            getNavigator().openMissingDataDialog();
            return;
        }
        else{
            dispose(authentication.login(new LoginRequest(username.get(), password.get())),
                    response -> {
                        int statusCode = -1;
                   /* if (statusCode == Constant.CORRECT_PASSWORD) {
                        getNavigator().openCorrectDialog();
                    } else {
                        getNavigator().openWrongDialog();
                    }*/
                        //CHECK LOGIN CÓ ĐÚNG HAY KHÔNG
                        if (response.isAuthenticated())
                            getNavigator().openCorrectDialog(obj);
                        else{
                            getNavigator().openWrongDialog();
                        }
                    }, throwable -> {
                        getNavigator().handleError(throwable);
                    });
        }
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
