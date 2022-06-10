package k15hkii.se114.bookstore.data.model.api.voucher;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import k15hkii.se114.bookstore.data.model.api.book.BookTag;
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
    private DiscountType discountType;

    @Getter
    @Expose
    @SerializedName("require_   book_tag")
    private BookTag[] bookTags;

    @Getter
    @Expose
    @SerializedName("require_book_count")
    private int require_book;

    @Getter
    @Expose
    @SerializedName("require_min_value")
    private double minValue;

    @Getter
    @Expose
    @SerializedName("discount")
    private int discount;

}
