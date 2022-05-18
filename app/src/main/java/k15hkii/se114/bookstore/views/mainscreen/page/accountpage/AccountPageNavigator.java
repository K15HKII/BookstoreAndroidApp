package k15hkii.se114.bookstore.views.mainscreen.page.accountpage;

import k15hkii.se114.bookstore.viewmodel.base.INavigator;

public interface AccountPageNavigator extends INavigator {

    void openAccountInfo();

    void openVoucher();

    void openSetting();

    void openHelpCenter();

    void logOut();
}
