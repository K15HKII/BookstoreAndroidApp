package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class Voucher {
    @Getter
    @Expose
    @SerializedName("id")
    private int id;

    @Getter
    @Expose
    @SerializedName("userid")
    private int userid;

    @Getter
    @Expose
    @SerializedName("profileid")
    private int profileId;

    @Getter
    @Expose
    @SerializedName("vouchercode")
    private int voucherCode;

    @Getter
    @Expose
    @SerializedName("expireddate")
    private int expiredDate;

    @Getter
    @Expose
    @SerializedName("useddate")
    private int usedDate;
}
