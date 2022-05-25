package k15hkii.se114.bookstore.ui.mainscreen.page.accountpage;

import k15hkii.se114.bookstore.ui.base.INavigator;

public interface AccountPageNavigator extends INavigator {

    void openAccountInfo();

    void openVoucher();

    void openSetting();

    void openHelpPage();

    void logOut();
}
