package k15hkii.se114.bookstore.views.mainscreen.page.shippingpage;

import k15hkii.se114.bookstore.viewmodel.base.INavigator;

public interface ShippingPageNavigator extends INavigator {
    void openSearchView();

    void openNotificationView();

    void openOnCartView();

    void openFilterDialog();
}
