package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class StorageLogDetail{

    @Getter
    @Expose
    @SerializedName("book_id")
    private String bookId;

    @Getter
    @Expose
    @SerializedName("quantity")
    private Number quantity;
}
