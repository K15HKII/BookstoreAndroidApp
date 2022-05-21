package k15hkii.se114.bookstore.views.loginscreen;

import k15hkii.se114.bookstore.viewmodel.base.INavigator;

public interface LoginNavigator extends INavigator {
    void handleError(Throwable throwable);

    void login();

    void openHomeView();

    void openPasswordForget();

    void openRegister();
}
