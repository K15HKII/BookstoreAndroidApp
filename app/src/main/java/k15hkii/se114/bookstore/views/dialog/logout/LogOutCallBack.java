package k15hkii.se114.bookstore.views.dialog.logout;

import k15hkii.se114.bookstore.viewmodel.base.INavigator;

public interface LogOutCallBack extends INavigator {
    void dismissDialog();

    void openLoginScreen();
}
