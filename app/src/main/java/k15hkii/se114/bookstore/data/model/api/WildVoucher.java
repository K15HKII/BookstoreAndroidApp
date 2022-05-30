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
public class WildVoucher {
    @Getter
    @Expose
    @SerializedName("id")
    private String id;

    @Getter
    @Expose
    @SerializedName("profileid")
    private String profileId;

    @Getter
    @Expose
    @SerializedName("amount")
    private int amount;

    @Getter
    @Expose
    @SerializedName("releasedate")
    private Date releaseDate;

    @Getter
    @Expose
    @SerializedName("expirydate")
    private Date expiryDate;

    @Getter
    @Expose
    @SerializedName("used")
    private boolean used;
}
