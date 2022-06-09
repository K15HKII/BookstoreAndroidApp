package k15hkii.se114.bookstore.data.model.api.cartitem;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class CartItemCRUDRequest {

    @Expose
    @Getter
    @Setter
    @SerializedName("book_id")
    private UUID bookId;

    @Expose
    @Getter
    @Setter
    @SerializedName("quantity")
    private int quantity;

    @Expose
    @Getter
    @SerializedName("selected")
    private boolean selected;

}
