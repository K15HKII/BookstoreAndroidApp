package k15hkii.se114.bookstore.ui.account;

import k15hkii.se114.bookstore.ui.base.INavigator;

public interface AccountPageNavigator extends INavigator {

    void openChangeNameDialog();

    void openChangePasswordDialog();

    void openChangePhoneNumDialog();

    void openChangeGenderDialog();

    void openChangeBirthDialog();

    void openSelectAddress();

    void openSelectBank();

    void openSetting();

    void openHelpPage();

    void openFavoritePage();

    void openWaitingOrder();

    void openShippingOrder();

    void openArrivedOrder();

    void openCancleOrder();

    void openRenting();

    void openRented();

    void openRencentBook();

    void logOut();

}
