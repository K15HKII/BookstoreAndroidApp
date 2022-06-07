package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import k15hkii.se114.bookstore.data.model.api.user.UserAddress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.UUID;

@With
@AllArgsConstructor
@NoArgsConstructor
public class Bill {

    @Getter
    @Expose
    @SerializedName("id")
    private int id;

    @Getter
    @Expose
    @SerializedName("transport")
    private Transport transport;

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
    @SerializedName("user_address")
    private UserAddress userAddress;

    @Expose
    @Getter
    @SerializedName("voucher_profile")
    private VoucherProfile voucherProfile;

    @Expose
    @Getter
    @SerializedName("payment")
    private String payment;
}
