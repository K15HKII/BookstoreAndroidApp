package k15hkii.se114.bookstore.ui.accountscreen.accountinfopage;

import k15hkii.se114.bookstore.ui.base.INavigator;

public interface AccountInfoNavigator extends INavigator {

    void BackWard();

    void openChangeNameDialog();

    void openChangePasswordDialog();

    void openChangePhoneNumDialog();

    void openChangeGenderDialog();

    void openChangeBirthDialog();

    void openSelectAddress();

    void openSelectBank();
}
