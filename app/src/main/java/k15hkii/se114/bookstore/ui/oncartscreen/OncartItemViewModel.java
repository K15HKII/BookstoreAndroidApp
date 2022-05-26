package k15hkii.se114.bookstore.ui.oncartscreen;

import k15hkii.se114.bookstore.data.model.api.BookProfile;
import k15hkii.se114.bookstore.data.model.api.BookProfileImage;
import k15hkii.se114.bookstore.data.model.api.CartItem;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;

public class OncartItemViewModel extends BaseViewModel<OncartItemNavigator> {
    String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public OncartItemViewModel(String name) {
        super(null);
        Name = name;
    }
    @Inject
    protected ModelRemote remote;

    private String userId;
    private String bookProfileId;
    private CartItem cartItem;
    private BookProfile bookProfile;
    private BookProfileImage bookProfileImage;

    public void getCardItem(String userId, String bookProfileId) {
        this.bookProfileId = bookProfileId;
        this.userId = userId;
        remote.getCartitem(userId,bookProfileId).doOnSuccess(cartItem -> {
            this.cartItem = cartItem;
        }).subscribe();
        remote.getBookprofile(bookProfileId).doOnSuccess(bookProfile -> {
            this.bookProfile = bookProfile;
        }).subscribe();
        remote.getBookprofileimage(bookProfileId, 1).doOnSuccess(bookProfileImage -> {
            this.bookProfileImage = bookProfileImage;
        }).subscribe();
    }

    public void openItemDetail(String bookProfileId){
        getNavigator().openBookDetailNavigator(bookProfileId);
    }
}
