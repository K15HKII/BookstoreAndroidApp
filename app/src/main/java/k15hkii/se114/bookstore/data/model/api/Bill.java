package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class Bill {
    @Getter
    @Expose
    @SerializedName("id")
    private int id;

    @Getter
    @Expose
    @SerializedName("date")
    private int date;

    @Getter
    @Expose
    @SerializedName("transportid")
    private int transportId;

    @Getter
    @Expose
    @SerializedName("userid")
    private int userid;

    @Getter
    @Expose
    @SerializedName("billstatus")
    private int billStatus;
}
