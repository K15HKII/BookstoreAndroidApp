package k15hkii.se114.bookstore.data;

import k15hkii.se114.bookstore.data.model.api.cartitem.CartItem;
import lombok.Getter;

import java.util.List;

public class DataSession {

    @Getter private List<CartItem> carts;

}
