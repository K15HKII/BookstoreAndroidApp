package k15hkii.se114.bookstore.model;

import android.text.TextUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
public class UserAccount {
    private String UserName;
    private String Password;

    public boolean isValidUserName(){
        return !TextUtils.isEmpty(UserName);
    }

    public boolean isValidPassword(){
        return !TextUtils.isEmpty(Password);
    }
}
