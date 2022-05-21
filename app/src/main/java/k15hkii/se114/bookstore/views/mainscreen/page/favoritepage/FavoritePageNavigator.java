package k15hkii.se114.bookstore.views.mainscreen.page.favoritepage;

import k15hkii.se114.bookstore.viewmodel.base.INavigator;

public interface FavoritePageNavigator extends INavigator {
    void openSearchView();

    void openNotificationView();

    void openOnCartView();

    void openFilterDialog();
}
