package k15hkii.se114.bookstore.data.model.api.bill;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import k15hkii.se114.bookstore.data.model.api.Payment;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@With
@AllArgsConstructor
@NoArgsConstructor
public class Bill implements Serializable {

    @Getter
    @Expose
    @SerializedName("id")
    private int id;

    @Getter
    @Expose
    @SerializedName("transport_id")
    private String transportId;

    @Getter
    @Expose
    @SerializedName("userid")
    private UUID userid;

    @Getter
    @Expose
    @SerializedName("status")
    private BillStatus status;

    @Expose
    @Getter
    @SerializedName("bill_details")
    private BillDetail[] billDetails;

    @Expose
    @Getter
    @SerializedName("address_id")
    private long userAddress;


    @Expose
    @Getter
    @SerializedName("payment")
    private Payment payment;

//    @Expose
//    @Getter
//    @Setter
//    private String price;
}
