package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.Date;

@With
@AllArgsConstructor
@NoArgsConstructor
public class Voucher {
    @Getter
    @Expose
    @SerializedName("id")
    private String id;

    @Getter
    @Expose
    @SerializedName("userid")
    private String userid;

    @Getter
    @Expose
    @SerializedName("profileid")
    private String profileId;

    @Getter
    @Expose
    @SerializedName("vouchercode")
    private String voucherCode;

    @Getter
    @Expose
    @SerializedName("expireddate")
    private Date expiredDate;

    @Getter
    @Expose
    @SerializedName("useddate")
    private Date usedDate;
}
