package k15hkii.se114.bookstore.ui.oncartscreen;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.data.model.api.cartitem.CartItem;
import k15hkii.se114.bookstore.data.model.api.cartitem.CartItemCRUDRequest;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;

public class OncartItemViewModel extends BaseViewModel<OncartItemNavigator> implements Observable {

    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<Double> price = new ObservableField<>();
    public ObservableField<Integer> quantity = new ObservableField<>();
    public ObservableField<Boolean> isSelectedItem = new ObservableField<>();

    @Inject
    protected ModelRemote remote;

    private CartItem cartItem;

    @Getter
    @Setter
    Book book;

    public OncartItemViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
    }

    void getData() {
        dispose(remote.getBook(cartItem.getBookId()),
                book -> {
                    this.book = book;
                    this.name.set(book.getTitle());
                    this.quantity.set(cartItem.getQuantity());
                    this.price.set(Double.parseDouble(String.valueOf(book.getPrice() * quantity.get())));
                    this.isSelectedItem.set(cartItem.isSelected());
                },
                throwable -> Log.d("OncartViewViewModel",
                                   "getData: " + throwable.getMessage(), throwable));
    }

    public void setCartItem(CartItem cartItem) throws InterruptedException {
        this.cartItem = cartItem;
        quantity.set(cartItem.getQuantity());
        getData();
//        wait();
    }

    public void deleteItem() {
        dispose(remote.deleteCart(book.getId()), a -> { }, throwable -> { });
//        remote.deleteCart(book.getId());
    }

    public void plusQuantity() {
        if (quantity.get() >= book.getStock()) {
            return;
        } else {
            quantity.set((quantity.get() + 1));
            this.price.set(Double.parseDouble(String.valueOf(book.getPrice() * quantity.get())));
        }
    }

    public void minusQuantity() {
        if (quantity.get() == 1) {
            return;
        } else {
            quantity.set((quantity.get() - 1));
            this.price.set(Double.parseDouble(String.valueOf(book.getPrice() * quantity.get())));
        }
    }

    public void CheckHandle() {
        if (cartItem.isSelected() == false && isSelectedItem.get()) {
            isSelectedItem.set(true);
            postCart(true);
//            this.getNavigator().checkItemHandle();
        }
        else if (cartItem.isSelected() == true){
            isSelectedItem.set(false);
            postCart(false);
//            this.getNavigator().checkItemHandle();
        }
    }

    void postCart(boolean status) {
        CartItemCRUDRequest request = new CartItemCRUDRequest();
        request.setBookId(book.getId());
        request.setQuantity(quantity.get());
        request.setSelected(status);
        dispose(remote.createCart(cartItem.getUserId(), request),
                cartItem -> {},
                throwable -> {});
    }
}
