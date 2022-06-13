package k15hkii.se114.bookstore.data.model.api.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class RecentBookCRUDRequest {

    @Expose
    @SerializedName("book_id")
    @Getter
    @Setter
    private UUID bookId;

    @Expose
    @SerializedName("selected")
    @Getter
    private boolean selected;

}
