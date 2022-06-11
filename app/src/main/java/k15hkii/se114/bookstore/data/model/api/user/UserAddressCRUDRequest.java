package k15hkii.se114.bookstore.data.model.api.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UserAddressCRUDRequest {

    @Expose
    @SerializedName("street")
    @Getter
    private String street;

    @Expose
    @SerializedName("city")
    @Getter
    private String city;

    @Expose
    @SerializedName("zip")
    @Getter
    private String zip;

    @Expose
    @SerializedName("country")
    @Getter
    private String country;

}
