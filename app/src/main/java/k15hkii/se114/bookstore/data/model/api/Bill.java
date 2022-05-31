package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.Date;
import java.util.List;
@With
@AllArgsConstructor
@NoArgsConstructor
public class Bill {

    @Getter
    @Expose
    @SerializedName("id")
    private Number id;

    @Getter
    @Expose
    @SerializedName("transport")
    private Transport transport;

    @Getter
    @Expose
    @SerializedName("userid")
    private String userid;

    @Getter
    @Expose
    @SerializedName("status")
    private String status;

    @Expose
    @Getter
    @SerializedName("bill_details")
    private BillDetail[] billDetails;

}
