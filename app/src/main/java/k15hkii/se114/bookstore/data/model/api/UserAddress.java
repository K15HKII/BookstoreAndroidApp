package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class UserAddress {
    @Getter
    @Expose
    @SerializedName("userid")
    private int userid;

    @Getter
    @Expose
    @SerializedName("index")
    private int index;

    @Getter
    @Expose
    @SerializedName("address")
    private int address;

    @Getter
    @Expose
    @SerializedName("city")
    private int city;

    @Getter
    @Expose
    @SerializedName("state")
    private int state;

    @Getter
    @Expose
    @SerializedName("country")
    private int country;

    @Getter
    @Expose
    @SerializedName("zipcode")
    private int zipcode;

    @Getter
    @Expose
    @SerializedName("is_primary")
    private int is_primary;
}
