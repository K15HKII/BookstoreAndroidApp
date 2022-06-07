package k15hkii.se114.bookstore.data.model.api.lend;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

public class LendRequest {

    public LendRequest() {
    }

    public LendRequest(UUID... bookIds) {
        this.bookIds = bookIds;
    }

    @Expose
    @SerializedName("book_ids")
    @Getter
    private UUID[] bookIds;

    @Expose
    @SerializedName("end_date")
    @Getter
    private Date endDate;

}
