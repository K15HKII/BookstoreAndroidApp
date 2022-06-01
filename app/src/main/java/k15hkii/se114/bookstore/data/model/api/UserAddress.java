package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.UUID;

@With
@AllArgsConstructor
@NoArgsConstructor
public class UserAddress {
    @Getter
    @Expose
    @SerializedName("userid")
    private UUID userId;

    @Getter
    @Expose
    @SerializedName("index")
    private String index;

    @Getter
    @Expose
    @SerializedName("street")
    private String street;

    @Getter
    @Expose
    @SerializedName("city")
    private String city;

    @Getter
    @Expose
    @SerializedName("country")
    private String country;

    @Getter
    @Expose
    @SerializedName("zip")
    private String zip;

    @Getter
    @Expose
    @SerializedName("is_primary")
    private boolean is_primary;
}
