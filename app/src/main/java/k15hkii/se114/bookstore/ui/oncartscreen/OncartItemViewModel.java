package k15hkii.se114.bookstore.ui.oncartscreen;

import androidx.databinding.Bindable;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.model.api.CartItem;
import k15hkii.se114.bookstore.data.model.api.Image;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

public class OncartItemViewModel extends BaseViewModel<OncartItemNavigator> {

    @Bindable
    @Getter @Setter
    private String Name;
    private CartItem cartItem;

    public OncartItemViewModel(String name) {
        super(null);
        Name = name;
    }
    public OncartItemViewModel(){
        super(null);
    }
    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }
    @Inject
    protected ModelRemote remote;

    private String userId;
    private String bookProfileId;
    private Book bookProfile;
    private List<Image> images;

    public void getCardItem(UUID userId, UUID bookProfileId) {
//        this.bookProfileId = bookProfileId;
//        this.userId = userId;
        /*remote.getCarts(userId,bookProfileId).doOnSuccess(cartItem -> {
            this.cartItem = cartItem;
        }).subscribe();*/ //TODO
        remote.getBook(bookProfileId).doOnSuccess(bookProfile -> {
            this.bookProfile = bookProfile;
        }).subscribe();
        /*remote.getBookImages().doOnSuccess(bookProfileImage -> {
            this.images = bookProfileImage;
        }).subscribe();*/ //TODO:
    }

    public void openItemDetail(String bookProfileId){
        getNavigator().openBookDetailNavigator(bookProfileId);
    }
}
