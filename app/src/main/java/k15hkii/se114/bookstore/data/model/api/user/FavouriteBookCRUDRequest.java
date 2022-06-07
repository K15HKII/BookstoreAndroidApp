package k15hkii.se114.bookstore.data.model.api.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.UUID;

public class FavouriteBookCRUDRequest {

    @Expose
    @SerializedName("book_id")
    @Getter
    private UUID bookId;

    @Expose
    @SerializedName("selected")
    @Getter
    private boolean selected;

}
