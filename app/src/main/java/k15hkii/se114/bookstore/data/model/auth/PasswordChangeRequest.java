package k15hkii.se114.bookstore.data.model.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

public class PasswordChangeRequest {

    @Expose
    @SerializedName("old_password")
    @Getter
    @Setter
    private String oldPassword;

    @Expose
    @SerializedName("new_password")
    @Getter
    @Setter
    private String newPassword;

}
