package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview;

import k15hkii.se114.bookstore.ui.base.INavigator;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderViewViewModel;

public interface IOrderNavigator extends INavigator {

    void Navigate(OrderViewViewModel vm);

}
