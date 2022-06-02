package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.UUID;

@With
@AllArgsConstructor
@NoArgsConstructor
public class BillDetail {
    @Getter
    @Expose
    @SerializedName("bill_id")
    private UUID billId;

    @Getter
    @Expose
    @SerializedName("book_id")
    private UUID bookId;

    @Getter
    @Expose
    @SerializedName("price")
    private double price;

    @Getter
    @Expose
    @SerializedName("quantity")
    private int quantity;
}
