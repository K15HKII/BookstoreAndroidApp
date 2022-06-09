package k15hkii.se114.bookstore.data.model.api.voucher;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

@With
@AllArgsConstructor
@NoArgsConstructor
public class WildVoucher extends BaseVoucher {
    @Getter
    @Expose
    @SerializedName("remaining_uses")
    private double remainingUses;

    @Getter
    @Expose
    @SerializedName("max_uses")
    private double maxUses;

}
