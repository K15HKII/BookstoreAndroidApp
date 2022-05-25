package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class Book {
    @Getter
    @Expose
    @SerializedName("id")
    private int id;

    @Getter
    @Expose
    @SerializedName("profileid")
    private int profileId;
}
