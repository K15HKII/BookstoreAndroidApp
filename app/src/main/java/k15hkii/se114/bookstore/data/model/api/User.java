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
    private String firstname;

    @Getter
    @Expose
    @SerializedName("lastname")
    private String lastname;

    @Getter
    @Expose
    @SerializedName("phone")
    private Number phone;


    @Getter
    @Expose
    @SerializedName("username")
    private String username;

    @Getter
    @Expose
    @SerializedName("salt")
    private boolean salt;

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
    private int refresh_token;

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
