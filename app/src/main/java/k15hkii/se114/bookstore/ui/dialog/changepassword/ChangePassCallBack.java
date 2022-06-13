package k15hkii.se114.bookstore.ui.dialog.changepassword;

import k15hkii.se114.bookstore.ui.base.INavigator;

public interface ChangePassCallBack extends INavigator {

    void dismissDialog();

    void openMissingDataDialog(String error);

    void openInvalidPasswordDialog(String error);

}
