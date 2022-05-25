package k15hkii.se114.bookstore.views.mainscreen.page.homepage;

import k15hkii.se114.bookstore.viewmodel.base.INavigator;

public interface HomePageNavigator extends INavigator {

    void openSearchView();

    void openNotificationView();

    void openOnCartView();

    void openFilterDialog();

    void openAllBooksView();

    void openPoppularBooksView();

    void openFamiliarBooksView();

    void openForYouBooksView();

}
