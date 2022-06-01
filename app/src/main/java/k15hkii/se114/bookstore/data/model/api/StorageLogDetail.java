package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.UUID;

public class StorageLogDetail{

    @Getter
    @Expose
    @SerializedName("book_id")
    private UUID bookId;

    @Getter
    @Expose
    @SerializedName("quantity")
    private int quantity;
}
