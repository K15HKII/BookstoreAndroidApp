package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.Date;
import java.util.List;

public class Bill {

    @Getter
    @Expose
    @SerializedName("id")
    private String id;

    @Getter
    @Expose
    @SerializedName("date")
    private Date date;

    @Getter
    @Expose
    @SerializedName("transportid")
    private String transportId;

    @Getter
    @Expose
    @SerializedName("userid")
    private String userid;

    @Getter
    @Expose
    @SerializedName("billstatus")
    private int billStatus;

    @Expose
    @Getter
    @SerializedName("billdetails")
    private List<BillDetail> billDetails;

}
