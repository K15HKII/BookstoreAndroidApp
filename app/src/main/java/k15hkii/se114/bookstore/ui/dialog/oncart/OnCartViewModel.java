package k15hkii.se114.bookstore.ui.dialog.oncart;

import android.util.Log;
import androidx.databinding.ObservableInt;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.data.model.api.cartitem.CartItemCRUDRequest;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import java.util.UUID;

public class OnCartViewModel extends BaseViewModel<OnCartCallBack> {

    public final ObservableInt quantity = new ObservableInt();
    PreferencesHelper helper;

    protected ModelRemote remote;
    private Book book;
    private UUID userId;

    //TODO: thêm sách chưa đúng
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

    public void postCart() {
        if (quantity.get() < 1)
            return;

        CartItemCRUDRequest request = new CartItemCRUDRequest();
        request.setBookId(book.getId());
        request.setSelected(false);
        request.setQuantity(quantity.get());
        request.setQuantityAction("add");

        dispose(remote.createCart(userId, request),
                cartItem -> {
                    getNavigator().dismissDialog();
                },
                throwable -> {
                    Log.d("OnCartViewModel", throwable.getMessage());
                });
    }

    public void plusQuantity() {
        if (quantity.get() >= book.getStock()) {
            return;
        }

        quantity.set(quantity.get() + 1);
    }

    public void minusQuantity() {
        if (quantity.get() == 1) {
            return;
        }

        quantity.set(quantity.get() - 1);
    }

    public void accept() {
        postCart();
    }

}
