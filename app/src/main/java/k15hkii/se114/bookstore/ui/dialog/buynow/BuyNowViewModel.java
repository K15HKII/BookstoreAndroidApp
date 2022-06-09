package k15hkii.se114.bookstore.ui.dialog.buynow;

import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.model.api.cartitem.CartItemCRUDRequest;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;

public class BuyNowViewModel extends BaseViewModel<BuyNowCallBack> {

    public final ObservableField<Integer> quantity = new ObservableField<>();
    PreferencesHelper helper;

    @Inject
    protected ModelRemote remote;
    private Book book;

    public BuyNowViewModel(ModelRemote remote, PreferencesHelper helper) {
        super(null);
        this.remote = remote;
        this.helper = helper;
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
        remote.createCart(helper.getCurrentUserId(), request);
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
