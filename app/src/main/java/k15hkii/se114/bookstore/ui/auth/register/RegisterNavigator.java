package k15hkii.se114.bookstore.ui.auth.register;

import k15hkii.se114.bookstore.ui.base.INavigator;

public interface RegisterNavigator extends INavigator {

    void BackWard();

    void openErrorData(String errorMessage);

    void openEmptyData(String errorMessage);

    void openCreateSuccess(String check);

    void openLogin();

}
