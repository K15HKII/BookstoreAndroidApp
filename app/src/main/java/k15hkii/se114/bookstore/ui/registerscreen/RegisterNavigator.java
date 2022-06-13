package k15hkii.se114.bookstore.ui.registerscreen;

import k15hkii.se114.bookstore.ui.base.INavigator;

public interface RegisterNavigator extends INavigator {

    void BackWard();

    void openErrorData(String errorMessage);

    void openEmptyData(String errorMessage);
}
