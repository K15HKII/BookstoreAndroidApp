package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

@With
@AllArgsConstructor
@NoArgsConstructor
public class Transport {
    @Getter
    @Expose
    @SerializedName("id")
    private String id;

    @Getter
    @Expose
    @SerializedName("transporterid")
    private String transporterId;

    @Getter
    @Expose
    @SerializedName("transportid")
    private String transportId;
}
