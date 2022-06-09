package k15hkii.se114.bookstore.ui.oncartscreen;

import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.data.model.api.cartitem.CartItem;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;

public class OncartItemViewModel extends BaseViewModel<OncartItemNavigator> {

    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> price = new ObservableField<>();
    public ObservableField<Integer> quantity = new ObservableField<>();
    public ObservableField<Boolean> isSelectedItem = new ObservableField<>();

    @Inject protected ModelRemote remote;

    private CartItem cartItem;

    @Getter @Setter Book book;

    public OncartItemViewModel(SchedulerProvider schedulerProvider, ModelRemote remote){
        super(schedulerProvider);
        this.remote = remote;
    }

//    void getData() {
//        getCompositeDisposable().add(remote.getBook(cartItem.getBookId())
//                                           .subscribeOn(getSchedulerProvider().io())
//                                           .observeOn(getSchedulerProvider().ui())
//                                           .subscribe(book -> {
//                                               this.book = book;
//                                               this.name.set(book.getTitle());
//                                               this.price.set(String.valueOf(book.getPrice()));
//                                               this.quantity.set(String.valueOf(cartItem.getQuantity()));
//                                           }, throwable -> {
//                                               Log.d("OncartViewViewModel", "getData: " + throwable.getMessage(), throwable);
//                                           }));
//    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
        cartItem.setSelected(false);
        quantity.set(cartItem.getQuantity());
        //todo: get data
//        getData();
    }

    public void deleteItem() {
        remote.deleteCart(book.getId());
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
