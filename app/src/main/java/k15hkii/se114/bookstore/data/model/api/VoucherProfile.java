package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;
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
    private DiscountType discountType;

    @Getter
    @Expose
    @SerializedName("book_tag")
    private BookTag[] bookTags;

    @Getter
    @Expose
    @SerializedName("discount_max")
    private double discountMax;

    @Getter
    @Expose
    @SerializedName("min_value")
    private double minValue;

    @Getter
    @Expose
    @SerializedName("discount")
    private int discount;

    @Getter
    @Expose
    @SerializedName("vouchers")
    private List<Voucher> vouchers;

    @Getter
    @Expose
    @SerializedName("wild_vouchers")
    private List<WildVoucher> wildVouchers;
}
