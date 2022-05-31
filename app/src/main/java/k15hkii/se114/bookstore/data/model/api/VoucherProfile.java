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
public class VoucherProfile {
    @Getter
    @Expose
    @SerializedName("id")
    private UUID id;

    @Getter
    @Expose
    @SerializedName("name")
    private String name;

    @Getter
    @Expose
    @SerializedName("description")
    private String description;

    @Getter
    @Expose
    @SerializedName("discount_type")
    private String discountType;

    @Getter
    @Expose
    @SerializedName("discount")
    private Number discount;

    @Getter
    @Expose
    @SerializedName("vouchers")
    private Voucher[] vouchers;

    @Getter
    @Expose
    @SerializedName("wild_vouchers")
    private WildVoucher[] wildVouchers;
}
