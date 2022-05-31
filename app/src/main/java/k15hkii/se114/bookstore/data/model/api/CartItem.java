package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

@With
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    @Getter
    @Expose
    @SerializedName("user_id")
    private String userId;

    @Getter
    @Expose
    @SerializedName("book_id")
    private String bookId;

    @Getter
    @Expose
    @SerializedName("book")
    private Book book;

    @Getter
    @Expose
    @SerializedName("selected")
    private boolean selected;
}
