package k15hkii.se114.bookstore.ui.orderinfoscreen.orderConfirm;

import android.util.Log;
import k15hkii.se114.bookstore.data.model.api.Payment;
import k15hkii.se114.bookstore.data.model.api.bill.BillCreateRequest;
import k15hkii.se114.bookstore.data.model.api.cartitem.CartItem;
import k15hkii.se114.bookstore.data.model.api.cartitem.CartItemCRUDRequest;
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

    public void getCartItems(UUID userId) {
        dispose(remote.getCarts(userId),
                cartItems -> {
                    List<OrderBookViewModel> list = new ArrayList<>();
                    price.set(0);
                    for (CartItem cartItem : cartItems) {
                        if (!cartItem.isSelected())
                            continue;
                        OrderBookViewModel vm = new OrderBookViewModel(getSchedulerProvider(), remote);
                        dispose(remote.getBook(cartItem.getBookId()),
                                book -> {
                                    vm.setBook(book, cartItem.getQuantity());
                                    price.set(price.get() + vm.price.get());
                                }, error -> {
                                    Log.d("getCartItems", error.getMessage(), error);
                                });
                        list.add(vm);
                    }
                    this.items.set(list);
                },
                throwable -> {
                    Log.d("getCartItems", throwable.getMessage(), throwable);
                });
        this.paymentMethod.set(Payment.CASH);

        dispose(remote.getAddresses(userId),
                addresses -> {
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
    }

    public OrderInfoPageViewModel(SchedulerProvider schedulerProvider, PreferencesHelper helper, ModelRemote remote,
                                  ViewModelMapper mapper) {
        super(schedulerProvider, mapper, remote);
        getCartItems(helper.getCurrentUserId());
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

    public BillCreateRequest toRequest() {
        BillCreateRequest request = new BillCreateRequest();

        if (address.get() != null) {
            request.setAddressId(address.get().getSubId());
        }
        if (bank.get() != null) {
            request.setBankId(bank.get().getSubId());
        }
        request.setPayment(paymentMethod.get());

        List<CartItemCRUDRequest> items = new ArrayList<>();
        for (OrderBookViewModel vm : this.items.get()) {
            CartItemCRUDRequest item = new CartItemCRUDRequest();
            item.setQuantity(vm.quantity.get());
            item.setBookId(vm.getBook().getId());
            items.add(item);
        }
        request.setItems(items);

        //TODO: vouchers

        return request;
    }

    public void openSuccessOrder() {
        dispose(remote.createBill(toRequest()), bill -> {
            getNavigator().SucceedOrder();
        }, throwable -> {
            Log.d("OrderInfoPageViewModel", "openSuccessOrder: " + throwable.getMessage());
        });
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
