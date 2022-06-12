package k15hkii.se114.bookstore.data.model.api.bill;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import k15hkii.se114.bookstore.data.model.api.Payment;
import k15hkii.se114.bookstore.data.model.api.voucher.VoucherProfile;
import lombok.*;

import java.io.Serializable;
import java.util.List;
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
    private UUID transportId;

    @Getter
    @Expose
    @SerializedName("user_id")
    private UUID userId;

    @Getter
    @Expose
    @SerializedName("status")
    private BillStatus status;

    @Expose
    @Getter
    @SerializedName("bill_details")
    private List<BillDetail> billDetails;

    @Expose
    @Getter
    @SerializedName("address_id")
    private long userAddressId;

    @Expose
    @Getter
    @SerializedName("used_vouchers")
    private List<VoucherProfile> usedVouchers;

    @Expose
    @Getter
    @SerializedName("payment")
    private Payment payment;

    //region Extra variables
    @Expose
    @Getter
    @SerializedName("total_details")
    private long totalDetails;

    @Expose
    @Getter
    @SerializedName("ship_cost")
    private long shipCost;
    //endregion

}
