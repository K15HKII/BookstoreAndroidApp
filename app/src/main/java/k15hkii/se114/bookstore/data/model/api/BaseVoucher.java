package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.Date;

public class BaseVoucher {
    @Getter
    @Expose
    @SerializedName("code")
    private String code;

    @Getter
    @Expose
    @SerializedName("release_date")
    private Date release_date;

    @Getter
    @Expose
    @SerializedName("expired_at")
    private Date expired_at;
}
