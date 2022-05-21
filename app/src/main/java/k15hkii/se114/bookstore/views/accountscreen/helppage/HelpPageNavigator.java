package k15hkii.se114.bookstore.views.accountscreen.helppage;

import k15hkii.se114.bookstore.viewmodel.base.INavigator;

public interface HelpPageNavigator extends INavigator {

    void BackWard();

    void openHelpCenter();

    void openAppIntroduction();

    void openPolicy();

    void openDeleteAccountRequest();
}
