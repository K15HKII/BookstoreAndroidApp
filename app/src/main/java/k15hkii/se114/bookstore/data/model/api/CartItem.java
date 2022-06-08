package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import k15hkii.se114.bookstore.data.model.api.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.UUID;

@With
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    @Getter
    @Expose
    @SerializedName("user_id")
    private UUID userId;

    @Getter
    @Expose
    @SerializedName("book_id")
    private UUID bookId;

    @Getter
    @Expose
    @SerializedName("quantity")
    private int quantity;

    @Getter
    @Expose
    @SerializedName("selected")
    private boolean selected;
}
