package k15hkii.se114.bookstore.ui.dialog.oncart;

import android.util.Log;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.model.api.cartitem.CartItem;
import k15hkii.se114.bookstore.data.model.api.cartitem.CartItemCRUDRequest;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.UUID;

public class OnCartViewModel extends BaseViewModel<OnCartCallBack> {

    public final ObservableField<Integer> quantity = new ObservableField<>();
    PreferencesHelper helper;

    @Inject
    protected ModelRemote remote;
    private Book book;
    private UUID userId;
    private CartItem cartItem;

    public OnCartViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper helper) {
        super(schedulerProvider);
        this.remote = remote;
        this.helper = helper;
        userId = helper.getCurrentUserId();
    }

    public void setData(Book book) {
        this.book = book;
        quantity.set(1);
    }

    void postCart() {
        CartItemCRUDRequest request = new CartItemCRUDRequest();
        request.setBookId(book.getId());
        request.setQuantity(quantity.get());
        dispose(remote.createCart(userId, request),
                cartItem -> {},
                throwable -> {});
    }

    public void plusQuantity() {
        if (quantity.get() >= book.getStock()) {
            return;
        } else {
            quantity.set((quantity.get() + 1));
        }
    }

    public void minusQuantity() {
        if (quantity.get() == 0) {
            return;
        } else {
            quantity.set((quantity.get() - 1));
        }
    }

    public void dismissDialog() {
        postCart();
        getNavigator().dismissDialog();
    }

}
