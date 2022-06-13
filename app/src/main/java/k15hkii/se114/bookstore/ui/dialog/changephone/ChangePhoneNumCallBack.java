package k15hkii.se114.bookstore.ui.dialog.changephone;

import k15hkii.se114.bookstore.ui.base.INavigator;

public interface ChangePhoneNumCallBack extends INavigator {
    void dismissDialog();

    void openMissingPhoneDialog(String error);

    void openInvalidPhoneDialog(String error);
}
