package k15hkii.se114.bookstore.ui.cart;

import k15hkii.se114.bookstore.ui.base.INavigator;

import java.util.List;

public interface OncartViewPageNavigator extends INavigator {

    void BackWard();

    void OrderPageNavigator(OncartViewViewModel viewModel, List<OncartItemViewModel> selecteds);

    void openEmptyCart(String error);

}
