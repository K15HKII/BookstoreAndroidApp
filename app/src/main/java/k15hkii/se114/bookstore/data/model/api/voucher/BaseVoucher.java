package k15hkii.se114.bookstore.data.model.api.voucher;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

public class BaseVoucher {

    @Getter
    @Expose
    @SerializedName("id")
    private UUID id;

    @Getter
    @Expose
    @SerializedName("code")
    private String code;

    @Getter
    @Expose
    @SerializedName("release_date")
    private Date release_date;

    @Getter
    @Expose
    @SerializedName("expired_at")
    private Date expiredAt;

    @Getter
    @Expose
    @SerializedName("profile_id")
    private UUID profileId;

    @Getter
    @Expose
    @SerializedName("profile")
    private VoucherProfile profile;

    public String getDescription() {
        if (profile == null)
            return "Chưa có thông tin";

        DiscountType type = profile.getDiscountType();
        if (type == DiscountType.PERCENTAGE) {
            return String.format("%s %s%%", "Giảm giá", profile.getDiscount());
        } else {
            return String.format("%s %s", "Giảm giá", profile.getDiscount());
        }
    }

    public long getDiscount(long price) {
        if (profile == null)
            return 0;

        DiscountType type = profile.getDiscountType();
        if (type == DiscountType.PERCENTAGE) {
            return price * profile.getDiscount() / 100;
        } else {
            return profile.getDiscount();
        }
    }

}
