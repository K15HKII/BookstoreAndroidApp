package k15hkii.se114.bookstore.data.model.api.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@With
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public String getName() {
        StringBuilder sb = new StringBuilder();
        if (getFirstName() != null) {
            sb.append(getFirstName());
        }
        if (getLastName() != null) {
            sb.append(" ");
            sb.append(getLastName());
        }
        return sb.toString();
    }

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
    private String username;

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
    @SerializedName("created_at")
    private String createdAt;

    @Getter
    @Expose
    @SerializedName("addresses")
    private List<UserAddress> addresses;

    @Getter
    @Expose
    @SerializedName("banks")
    private List<UserBank> banks;

    @Getter
    @Expose
    @SerializedName("avatar")
    private Image avatar;

    @Getter
    @Expose
    @SerializedName("updated_at")
    private int updated_at;

}

