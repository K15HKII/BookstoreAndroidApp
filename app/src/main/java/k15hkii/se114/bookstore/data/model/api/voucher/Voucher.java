package k15hkii.se114.bookstore.data.model.api.voucher;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.Date;
import java.util.UUID;

@With
@AllArgsConstructor
@NoArgsConstructor
public class Voucher extends BaseVoucher {

    @Getter
    @Expose
    @SerializedName("user_id")
    private UUID userId;

    @Getter
    @Expose
    @SerializedName("used_at")
    private Date usedAt;

}
