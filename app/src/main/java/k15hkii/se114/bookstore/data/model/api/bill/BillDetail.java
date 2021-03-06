package k15hkii.se114.bookstore.data.model.api.bill;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.UUID;

@With
@AllArgsConstructor
@NoArgsConstructor
public class BillDetail {

    @Getter
    @Expose
    @SerializedName("bill_id")
    private int billId;

    @Getter
    @Expose
    @SerializedName("book_id")
    private UUID bookId;

    @Getter
    @Setter
    @Expose
    @SerializedName("unit_price")
    private double price;

    @Getter
    @Expose
    @SerializedName("quantity")
    private int quantity;

}
