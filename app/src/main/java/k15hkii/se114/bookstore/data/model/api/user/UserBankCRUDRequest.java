package k15hkii.se114.bookstore.data.model.api.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

public class UserBankCRUDRequest {

    @Expose
    @SerializedName("bank_name")
    @Getter
    @Setter
    private String bankName;

    @Expose
    @SerializedName("iban")
    @Getter
    @Setter
    private String iban;

    @Expose
    @SerializedName("bic")
    @Getter
    @Setter
    private String bic;

    @Expose
    @SerializedName("primary")
    @Getter
    @Setter
    private boolean primary;

}
