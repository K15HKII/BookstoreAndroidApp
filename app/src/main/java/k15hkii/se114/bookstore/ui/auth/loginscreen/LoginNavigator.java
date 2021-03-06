package k15hkii.se114.bookstore.ui.auth.loginscreen;

import k15hkii.se114.bookstore.ui.base.INavigator;

public interface LoginNavigator extends INavigator {

    void handleError(Throwable throwable);

    void login(Object obj);

    void openHomeView(Object... obj);

    void openPasswordForget(Object... obj);

    void openRegister(Object... obj);

    void openWrongDialog();

    void openCorrectDialog(Object obj, String check);

    void openMissingDataDialog();

}
