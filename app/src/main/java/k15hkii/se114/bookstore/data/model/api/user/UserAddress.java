package k15hkii.se114.bookstore.data.model.api.user;

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
    @SerializedName("sub_id")
    private long subId;

    @Getter
    @Expose
    @SerializedName("userid")
    private UUID userId;

    @Getter
    @Expose
    @SerializedName("number")
    private String number;

    @Expose
    @SerializedName("address")
    @Getter
    private String address;

    @Expose
    @SerializedName("street")
    @Getter
    private String street;

    @Expose
    @SerializedName("city")
    @Getter
    private String city;

    @Expose
    @SerializedName("ward")
    @Getter
    private String ward;

    @Expose
    @SerializedName("project")
    @Getter
    private String project;

    @Expose
    @SerializedName("district")
    @Getter
    private String district;

    @Getter
    @Expose
    @SerializedName("updated_at")
    private String updateAt;

    @Getter
    @Expose
    @SerializedName("is_primary")
    private boolean isPrimary;

}
