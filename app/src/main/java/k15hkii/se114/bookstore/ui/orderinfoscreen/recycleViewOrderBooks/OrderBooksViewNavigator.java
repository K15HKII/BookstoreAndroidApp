package k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks;

import k15hkii.se114.bookstore.ui.base.INavigator;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderViewViewModel;

public interface OrderBooksViewNavigator extends INavigator {
    void Navigate(OrderBookViewModel vm);
}
