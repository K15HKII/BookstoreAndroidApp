package k15hkii.se114.bookstore.data.model.api.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class ProfileUpdateRequest {

    @Expose
    @SerializedName("firstname")
    @Getter
    @Setter
    private String firstname;

    @Expose
    @SerializedName("lastname")
    @Getter
    @Setter
    private String lastname;

    @Expose
    @SerializedName("email")
    @Getter
    @Setter
    private String email;

    @Expose
    @SerializedName("phone")
    @Getter
    @Setter
    private String phone;

    @Expose
    @SerializedName("gender")
    @Getter
    @Setter
    private Gender gender;

    @Expose
    @SerializedName("birthday")
    @Getter
    @Setter
    private Date birthday;

    // TODO: Add Password Property
}
