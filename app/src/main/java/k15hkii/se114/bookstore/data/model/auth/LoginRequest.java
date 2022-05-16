package k15hkii.se114.bookstore.data.model.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class LoginRequest {

    @Expose
    @SerializedName("username")
    @Getter
    private String username;

    @Expose
    @SerializedName("password")
    @Getter
    private String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
