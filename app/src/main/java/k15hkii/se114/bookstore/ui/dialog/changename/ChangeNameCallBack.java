package k15hkii.se114.bookstore.ui.dialog.changename;

import k15hkii.se114.bookstore.ui.base.INavigator;

public interface ChangeNameCallBack extends INavigator {

    void dismissDialog();

    void openMissingNameDialog(String error);

    void openInvalidNameDialog(String error);

}
