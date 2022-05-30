package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.Date;

@With
@AllArgsConstructor
@NoArgsConstructor
public class Lend {
    @Getter
    @Expose
    @SerializedName("id")
    private String id;

    @Getter
    @Expose
    @SerializedName("userid")
    private String userid;

    @Getter
    @Expose
    @SerializedName("bookprofileid")
    private String bookProfileId;

    @Getter
    @Expose
    @SerializedName("start")
    private Date start;

    @Getter
    @Expose
    @SerializedName("end")
    private Date end;
}
