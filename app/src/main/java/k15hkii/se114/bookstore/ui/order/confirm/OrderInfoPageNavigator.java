package k15hkii.se114.bookstore.ui.order.confirm;

import k15hkii.se114.bookstore.ui.base.INavigator;

public interface OrderInfoPageNavigator extends INavigator {

    void BackWard();

    void SucceedOrder();

    void openSelectAddress();

    void openSelectVoucher();

    void openSelectPayment();

}
