package k15hkii.se114.bookstore.ui.orderinfoscreen.orderConfirm;

import k15hkii.se114.bookstore.data.model.api.bill.BillDetail;
import k15hkii.se114.bookstore.data.model.api.cartitem.CartItem;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.orderinfoscreen.BaseOrderInfoViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderInfoPageViewModel extends BaseOrderInfoViewModel<OrderInfoPageNavigator> {

    // TODO: T nghĩ cần BillRequest để gắn phương thức thanh toán, địa chỉ, đơn hàng, voucher này kia
    // ở đây set data cho view thì bill chưa được tạo, bấm nút đặt hàng rồi thì mới post bill

    public void getCartItems(UUID userId) {
        dispose(remote.getCarts(userId),
                cartItems -> {
                    List<OrderBookViewModel> list = new ArrayList<>();
                    for (CartItem cartItem : cartItems) {
                        OrderBookViewModel viewModel = new OrderBookViewModel(getSchedulerProvider(), remote);
                        viewModel.setOrderDetail(new BillDetail(-1, cartItem.getBookId(), 0, cartItem.getQuantity()));
                        list.add(viewModel);
                    }
                    this.items.set(list);
                },
                throwable -> { });
    }

    public OrderInfoPageViewModel(SchedulerProvider schedulerProvider, PreferencesHelper helper, ModelRemote remote,
                                  ViewModelMapper mapper) {
        super(schedulerProvider, mapper, remote);
        getCartItems(helper.getCurrentUserId());
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

    public void openSuccessOrder() {
        getNavigator().SucceedOrder();
    }

}
