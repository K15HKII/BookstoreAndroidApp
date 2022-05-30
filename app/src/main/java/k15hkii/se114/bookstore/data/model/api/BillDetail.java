package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class BillDetail {
    @Getter
    @Expose
    @SerializedName("billid")
    private String billId;

    @Getter
    @Expose
    @SerializedName("bookid")
    private String bookId;

    @Getter
    @Expose
    @SerializedName("price")
    private double price;
}
