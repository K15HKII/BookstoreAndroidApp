package k15hkii.se114.bookstore.data.model.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import k15hkii.se114.bookstore.data.model.api.user.Gender;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class RegisterRequest {

    @Expose
    @SerializedName("username")
    @Setter
    @Getter
    private String username;

    @Expose
    @SerializedName("password")
    @Setter
    @Getter
    private String password;

    @Expose
    @SerializedName("birthday")
    @Setter
    @Getter
    private Date birthday;

    @Expose
    @SerializedName("email")
    @Setter
    @Getter
    private String email;

    @Expose
    @SerializedName("phone")
    @Setter
    @Getter
    private String phone;

    @Expose
    @SerializedName("gender")
    @Setter
    @Getter
    private Gender gender;

}
