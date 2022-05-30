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
public class User {
    @Getter
    @Expose
    @SerializedName("id")
    private String id;

    @Getter
    @Expose
    @SerializedName("firstname")
    private int firstname;

    @Getter
    @Expose
    @SerializedName("lastname")
    private int lastname;

    @Getter
    @Expose
    @SerializedName("phone")
    private int phone;


    @Getter
    @Expose
    @SerializedName("username")
    private int username;

    @Getter
    @Expose
    @SerializedName("salt")
    private int salt;

    @Getter
    @Expose
    @SerializedName("password")
    private int password;

    @Getter
    @Expose
    @SerializedName("email")
    private int email;

    @Getter
    @Expose
    @SerializedName("role")
    private int role;

    @Getter
    @Expose
    @SerializedName("refresh_token")
    private int refresh_token;

    @Getter
    @Expose
    @SerializedName("created_at")
    private int created_at;

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
