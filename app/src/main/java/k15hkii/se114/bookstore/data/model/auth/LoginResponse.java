package k15hkii.se114.bookstore.data.model.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@ToString
public class LoginResponse {

    @Expose
    @SerializedName("access_token")
    @Getter
    private String accessToken;

    @Expose
    @SerializedName("refresh_token")
    @Getter
    private String refreshToken;

    @Expose
    @SerializedName("user_id")
    @Getter
    private UUID userId;

    @Expose
    @SerializedName("authenticated")
    @Getter
    private boolean authenticated;

}
