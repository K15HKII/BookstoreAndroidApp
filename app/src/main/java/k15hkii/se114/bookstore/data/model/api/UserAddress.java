package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

@With
@AllArgsConstructor
@NoArgsConstructor
public class UserAddress {
    @Getter
    @Expose
    @SerializedName("userid")
    private String userid;

    @Getter
    @Expose
    @SerializedName("index")
    private String index;

    @Getter
    @Expose
    @SerializedName("address")
    private String address;

    @Getter
    @Expose
    @SerializedName("city")
    private String city;

    @Getter
    @Expose
    @SerializedName("state")
    private String state;

    @Getter
    @Expose
    @SerializedName("country")
    private String country;

    @Getter
    @Expose
    @SerializedName("zipcode")
    private String zipcode;

    @Getter
    @Expose
    @SerializedName("is_primary")
    private boolean is_primary;
}
