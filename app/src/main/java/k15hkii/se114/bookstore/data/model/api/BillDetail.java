package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class BillDetail {
    @Getter
    @Expose
    @SerializedName("billid")
    private int billId;

    @Getter
    @Expose
    @SerializedName("bookid")
    private int bookId;

    @Getter
    @Expose
    @SerializedName("price")
    private int price;
}
