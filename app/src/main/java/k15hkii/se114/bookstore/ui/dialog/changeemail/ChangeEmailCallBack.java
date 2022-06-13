package k15hkii.se114.bookstore.ui.dialog.changeemail;

import k15hkii.se114.bookstore.ui.base.INavigator;

public interface ChangeEmailCallBack extends INavigator {

    void dismissDialog();

    void openMissingEmailDialog(String error);

    void openInvalidEmailDialog(String error);

}
