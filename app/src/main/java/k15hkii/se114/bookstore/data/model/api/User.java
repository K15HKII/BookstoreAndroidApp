package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@With
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Getter
    @Expose
    @SerializedName("id")
    private UUID id;

    @Getter
    @Expose
    @SerializedName("firstname")
    private String firstName;

    @Getter
    @Expose
    @SerializedName("lastname")
    private String lastName;

    @Getter
    @Expose
    @SerializedName("phone")
    private String phone;

    @Getter
    @Expose
    @SerializedName("age")
    private int age;

    @Getter
    @Expose
    @SerializedName("birthday")
    private Date birthday;

    @Getter
    @Expose
    @SerializedName("gender")
    private Gender gender;

    @Getter
    @Expose
    @SerializedName("username")
    private String userName;

    @Getter
    @Expose
    @SerializedName("salt")
    private String salt;

    @Getter
    @Expose
    @SerializedName("password")
    private String password;

    @Getter
    @Expose
    @SerializedName("email")
    private String email;

    @Getter
    @Expose
    @SerializedName("role")
    private String role;

    @Getter
    @Expose
    @SerializedName("refresh_token")
    private String refresh_token;

    @Getter
    @Expose
    @SerializedName("created_at")
    private String created_at;

    @Getter
    @Expose
    @SerializedName("updated_at")
    private int updated_at;

    @Getter
    @Expose
    @SerializedName("is_active")
    private int is_active;

    @Getter
    @Expose
    @SerializedName("is_verified")
    private int is_verified;

    @Getter
    @Expose
    @SerializedName("is_locked")
    private int is_locked;

    @Getter
    @Expose
    @SerializedName("is_blocked")
    private int is_blocked;

}

