package k15hkii.se114.bookstore.data.model.api.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class UserAddressCRUDRequest {

    @Expose
    @SerializedName("address")
    @Getter
    @Setter
    private String address;

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
    @SerializedName("ward")
    @Getter
    @Setter
    private String ward;

    @Expose
    @SerializedName("project")
    @Getter
    @Setter
    private String project;

    @Expose
    @SerializedName("district")
    @Getter
    @Setter
    private String district;

    @Expose
    @SerializedName("is_primary")
    @Getter
    @Setter
    private boolean isPrimary;

}
