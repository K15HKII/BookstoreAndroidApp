package k15hkii.se114.bookstore.views.searchbook;

import k15hkii.se114.bookstore.viewmodel.base.INavigator;

public interface SearchBookViewNavigator extends INavigator {
    void BackWard();

    void openSearchViewResult();
}