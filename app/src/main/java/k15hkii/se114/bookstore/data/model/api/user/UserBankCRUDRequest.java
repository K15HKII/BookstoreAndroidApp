package k15hkii.se114.bookstore.data.model.api.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class UserBankCRUDRequest {

    @Expose
    @SerializedName("bank_name")
    @Getter
    private String bankName;

    @Expose
    @SerializedName("iban")
    @Getter
    private String iban;

    @Expose
    @SerializedName("bic")
    @Getter
    private String bic;

}
