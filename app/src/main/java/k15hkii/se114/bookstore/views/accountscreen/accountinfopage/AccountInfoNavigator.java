package k15hkii.se114.bookstore.views.accountscreen.accountinfopage;

import k15hkii.se114.bookstore.viewmodel.base.INavigator;

public interface AccountInfoNavigator extends INavigator {

    void BackWard();

    void openChangeNameDialog();

    void openChangePasswordDialog();
}
