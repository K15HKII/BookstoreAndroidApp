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
public class UserBank {
    @Getter
    @Expose
    @SerializedName("userid")
    private String userId;

    @Getter
    @Expose
    @SerializedName("bank_name")
    private String bankName;

    @Getter
    @Expose
    @SerializedName("iban")
    private String iban;

    @Getter
    @Expose
    @SerializedName("bic")
    private String bic;
}

