package k15hkii.se114.bookstore.ui.cart;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.data.model.api.cartitem.CartItem;
import k15hkii.se114.bookstore.data.model.api.cartitem.CartItemCRUDRequest;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

public class OncartItemViewModel extends BaseViewModel<OncartItemNavigator> implements Observable {

    public interface UpdateCallback {

        void onUpdate();

    }

    public interface DeleteCallback {

        void onDelete();

    }

    @Getter
    private final List<UpdateCallback> updateCallbacks = new LinkedList<>();
    @Getter
    private final List<DeleteCallback> deleteCallbacks = new LinkedList<>();

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableInt price = new ObservableInt();
    public final ObservableInt quantity = new ObservableInt();
    public final ObservableField<Image> image = new ObservableField<>();
    public final ObservableBoolean isSelectedItem = new ObservableBoolean();

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
                    this.price.set(book.getPrice() * quantity.get());
                    if (book.getImages() != null && book.getImages().size() > 0) {
                        image.set(book.getImages().get(0));
                    }
                    this.isSelectedItem.set(cartItem.isSelected());
                },
                throwable -> Log.d("OncartViewViewModel",
                        "getData: " + throwable.getMessage(), throwable));
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
        quantity.set(cartItem.getQuantity());
        getData();
    }

    public void deleteItem() {
        dispose(remote.deleteCart(book.getId()), a -> {
            for (DeleteCallback callback : deleteCallbacks) {
                callback.onDelete();
            }
        }, throwable -> Log.d("OncartViewViewModel",
                "deleteItem: " + throwable.getMessage(), throwable));
    }

    public void plusQuantity() {
        quantity.set((quantity.get() + 1));
        this.price.set(book.getPrice() * quantity.get());
        for (UpdateCallback cb : updateCallbacks) {
            cb.onUpdate();
        }
        postCart(isSelectedItem.get());
    }

    public void minusQuantity() {
        if (quantity.get() < 2) {
            return;
        }
        quantity.set((quantity.get() - 1));
        this.price.set(book.getPrice() * quantity.get());
        for (UpdateCallback cb : updateCallbacks) {
            cb.onUpdate();
        }
        postCart(isSelectedItem.get());
    }

    public void toggleHandle() {
        isSelectedItem.set(!isSelectedItem.get());
        for (UpdateCallback cb : updateCallbacks) {
            cb.onUpdate();
        }
        postCart(isSelectedItem.get());
    }

    void postCart(boolean status) {
        CartItemCRUDRequest request = new CartItemCRUDRequest();
        request.setBookId(book.getId());
        request.setQuantity(quantity.get());
        request.setSelected(status);
        dispose(remote.createCart(cartItem.getUserId(), request),
                cartItem -> {
                },
                throwable -> {
                });
    }

}
