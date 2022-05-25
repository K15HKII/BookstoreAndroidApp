package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class Lend {
    @Getter
    @Expose
    @SerializedName("id")
    private int id;

    @Getter
    @Expose
    @SerializedName("userid")
    private int userid;

    @Getter
    @Expose
    @SerializedName("bookprofileid")
    private int bookProfileId;

    @Getter
    @Expose
    @SerializedName("start")
    private int start;

    @Getter
    @Expose
    @SerializedName("end")
    private int end;
}
