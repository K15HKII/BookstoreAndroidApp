package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@With
@AllArgsConstructor
@NoArgsConstructor
public class Lend {
    @Getter
    @Expose
    @SerializedName("id")
    private UUID id;

    @Getter
    @Expose
    @SerializedName("userId")
    private UUID userId;

    @Getter
    @Expose
    @SerializedName("transport")
    private Transport transport;

    @Getter
    @Expose
    @SerializedName("book")
    private Book book;

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


}
