package k15hkii.se114.bookstore.data.model.api.lend;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import k15hkii.se114.bookstore.data.model.api.Payment;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@With
@AllArgsConstructor
@NoArgsConstructor
public class Lend implements Serializable {

    @Getter
    @Expose
    @SerializedName("id")
    private UUID id;

    @Getter
    @Expose
    @SerializedName("user_id")
    private UUID userId;

    @Getter
    @Expose
    @SerializedName("book_id")
    private UUID bookId;

    @Getter
    @Expose
    @SerializedName("lend_status")
    private LendStatus lendStatus;

    @Getter
    @Expose
    @SerializedName("start_date")
    private Date startDate;

    @Getter
    @Expose
    @SerializedName("end_date")
    private Date endDate;

    @Getter
    @Expose
    @SerializedName("payment")
    private Payment payment;
}
