package k15hkii.se114.bookstore.ui.oncartscreen;

import k15hkii.se114.bookstore.ui.base.INavigator;

public interface OncartItemNavigator extends INavigator {

    void openBookDetailNavigator(OncartItemViewModel vm);

    void checkItemHandle();

    void deleteItem(int index);
}
