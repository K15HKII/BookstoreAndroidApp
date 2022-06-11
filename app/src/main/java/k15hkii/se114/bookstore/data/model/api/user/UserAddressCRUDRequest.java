package k15hkii.se114.bookstore.data.model.api.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

public class UserAddressCRUDRequest {

    @Expose
    @SerializedName("street")
    @Getter
    @Setter
    private String street;

    @Expose
    @SerializedName("city")
    @Getter
    @Setter
    private String city;

    @Expose
    @SerializedName("zip")
    @Getter
    @Setter
    private String zip;

    @Expose
    @SerializedName("country")
    @Getter
    @Setter
    private String country;

}
