package k15hkii.se114.bookstore.ui.dialog.buynow;

import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.data.model.api.cartitem.CartItemCRUDRequest;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.UUID;

public class BuyNowViewModel extends BaseViewModel<BuyNowCallBack> {

    public final ObservableField<Integer> quantity = new ObservableField<>();
    PreferencesHelper helper;

    @Inject
    protected ModelRemote remote;
    private Book book;
    private UUID userId;

    public BuyNowViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper helper) {
        super(schedulerProvider);
        this.remote = remote;
        this.helper = helper;
        this.userId = helper.getCurrentUserId();
    }

    public void dismissDialog(){
        postCart();
        getNavigator().dismissDialog();
        getNavigator().openCartPage();
    }

    void postCart() {
        CartItemCRUDRequest request = new CartItemCRUDRequest();
        request.setBookId(book.getId());
        request.setQuantity(quantity.get());
        dispose(remote.createCart(userId, request),
                cartItem -> {},
                throwable -> {});
    }

    public void setData(Book book) {
        this.book = book;
        quantity.set(1);
    }

    public void plusQuantity() {
        if (quantity.get() >= book.getStock()) {
            return;
        }
        else {
            quantity.set((quantity.get() + 1));
        }
    }

    public void minusQuantity() {
        if (quantity.get() == 0) {
            return;
        }
        else {
            quantity.set((quantity.get() - 1));
        }
    }
}
