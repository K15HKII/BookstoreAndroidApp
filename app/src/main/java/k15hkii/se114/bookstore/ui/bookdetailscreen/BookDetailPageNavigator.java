package k15hkii.se114.bookstore.ui.bookdetailscreen;

import k15hkii.se114.bookstore.ui.base.INavigator;

public interface BookDetailPageNavigator extends INavigator {
    void BackWard();

    void openBuyNowDialog();

    void openOnCartDialog();
}
