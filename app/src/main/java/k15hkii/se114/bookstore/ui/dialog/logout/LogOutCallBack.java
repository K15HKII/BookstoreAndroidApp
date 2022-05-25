package k15hkii.se114.bookstore.ui.dialog.logout;

import k15hkii.se114.bookstore.ui.base.INavigator;

public interface LogOutCallBack extends INavigator {
    void dismissDialog();

    void openLoginScreen();
}
