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
public class BillDetail {
    @Getter
    @Expose
    @SerializedName("bill_id")
    private Number billId;

    @Getter
    @Expose
    @SerializedName("book_id")
    private String bookId;

    @Getter
    @Expose
    @SerializedName("price")
    private Number price;

    @Getter
    @Expose
    @SerializedName("quantity")
    private Number quantity;
}
