package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview;

import k15hkii.se114.bookstore.ui.base.INavigator;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderViewViewModel;

public interface RentViewNavigator extends INavigator {
    void Navigate(RentViewViewModel vm);
}
