package k15hkii.se114.bookstore.views.mainscreen.page.rentpage;

import k15hkii.se114.bookstore.viewmodel.base.INavigator;

public interface RentPageNavigator extends INavigator {
    void openSearchView();

    void openNotificationView();

    void openOnCartView();

    void openAddRentBill();

    void openFilterDialog();
}
