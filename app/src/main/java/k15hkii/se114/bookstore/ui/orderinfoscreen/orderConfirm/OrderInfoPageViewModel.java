package k15hkii.se114.bookstore.ui.orderinfoscreen.orderConfirm;

import android.util.Log;
import io.reactivex.Observable;
import k15hkii.se114.bookstore.data.model.api.Payment;
import k15hkii.se114.bookstore.data.model.api.bill.Bill;
import k15hkii.se114.bookstore.data.model.api.bill.BillDetail;
import k15hkii.se114.bookstore.data.model.api.cartitem.CartItem;
import k15hkii.se114.bookstore.data.model.api.user.UserAddress;
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

    List<OrderBookViewModel> list = new ArrayList<>();
    List<BillDetail> billDetails = new ArrayList<>();

    public void getCartItems(UUID userId) {
        dispose(remote.getCarts(userId),
                cartItems -> {
                    for (CartItem cartItem : cartItems) {
                        OrderBookViewModel viewModel = new OrderBookViewModel(getSchedulerProvider(), remote);
                        BillDetail billDetail = new BillDetail(-1, cartItem.getBookId(), 0, cartItem.getQuantity());
                        viewModel.setOrderDetail(billDetail);
                        if (viewModel.price.get() != null) {
                            billDetail.setPrice(viewModel.price.get());
                        }
                        list.add(viewModel);
                        billDetails.add(billDetail);
                    }
                    this.items.set(list);
                },
                throwable -> { });

        this.voucher.set("Chọn");
        this.paymentMethod.set(Payment.CASH);

        dispose(remote.getAddresses(userId),
                addresses ->{
            for (UserAddress address : addresses) {
                if (address.isPrimary()) {
                    this.address.set(address);
                    return;
                }
            }
                },
                throwable -> {
                    Log.d("OrderInfoPageViewModel", "getAddress: " + throwable.getMessage());
                });

        //region Get total
        dispose(Observable.fromIterable(billDetails)
                          .map(detail -> detail.getPrice() * detail.getQuantity())
                          .reduceWith(() -> 0d, (a, b) -> a + b).map(Double::longValue), this.total::set, throwable -> {
            Log.d("OrderRatingViewModel", "getData: ", throwable);
        });
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
        //TODO: Post Bill
        getNavigator().SucceedOrder();
    }

    public void openSelectAddress() {
        //TODO: select Address page
        getNavigator().openSelectAddress();
    }

    public void openSelectVoucher() {
        //TODO: select Voucher page
        getNavigator().openSelectVoucher();
    }

    public void openSelectPaymentMethod() {
        //TODO: select PaymentMethod page
        getNavigator().openSelectPayment();
    }

}
