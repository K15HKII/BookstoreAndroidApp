package k15hkii.se114.bookstore.ui.oncartscreen;

import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.model.api.cartitem.CartItem;
import k15hkii.se114.bookstore.data.model.api.Image;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

public class OncartItemViewModel extends BaseViewModel<OncartItemNavigator> {

    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> price = new ObservableField<>();
    public ObservableField<String> quantity = new ObservableField<>();

    @Inject protected ModelRemote remote;

    private CartItem cartItem;

    @Getter @Setter Book book;

    public OncartItemViewModel(ModelRemote remote){
        super(null);
        this.remote = remote;
    }

    void getData() {
        remote.getBook(cartItem.getBookId())
              .doOnSuccess(book -> {
//            this.book = book;
//            this.name.set(book.getTitle());
//            this.price.set(String.valueOf(book.getPrice()));
        }).subscribe();
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
        getData();
    }
}
