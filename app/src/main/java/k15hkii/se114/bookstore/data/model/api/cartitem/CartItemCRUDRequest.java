package k15hkii.se114.bookstore.data.model.api.cartitem;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.UUID;

public class CartItemCRUDRequest {

    @Expose
    @Getter
    @SerializedName("book_id")
    private UUID bookId;

    @Expose
    @Getter
    @SerializedName("quantity")
    private int quantity;

    @Expose
    @Getter
    @SerializedName("selected")
    private boolean selected;

}
