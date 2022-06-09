package k15hkii.se114.bookstore.data.model.api.bill;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.UUID;

@With
@AllArgsConstructor
@NoArgsConstructor
public class Transport {

    @Getter
    @Expose
    @SerializedName("id")
    private UUID id;

    @Getter
    @Expose
    @SerializedName("transporter_id")
    private int transporterId;

    @Getter
    @Expose
    @SerializedName("tracking")
    private String tracking;

}
