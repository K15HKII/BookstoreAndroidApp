package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class WildVoucher {
    @Getter
    @Expose
    @SerializedName("id")
    private int id;

    @Getter
    @Expose
    @SerializedName("profileid")
    private int profileId;

    @Getter
    @Expose
    @SerializedName("amount")
    private int amount;

    @Getter
    @Expose
    @SerializedName("releasedate")
    private int releaseDate;

    @Getter
    @Expose
    @SerializedName("expirydate")
    private int expiryDate;

    @Getter
    @Expose
    @SerializedName("used")
    private int used;
}
