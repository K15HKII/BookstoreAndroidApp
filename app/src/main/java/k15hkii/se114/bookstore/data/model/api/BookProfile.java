package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class BookProfile {
    @Getter
    @Expose
    @SerializedName("id")
    private int id;

    @Getter
    @Expose
    @SerializedName("name")
    private int name;

    @Getter
    @Expose
    @SerializedName("tags")
    private int tags;

    @Getter
    @Expose
    @SerializedName("authorid")
    private int authorId;

    @Getter
    @Expose
    @SerializedName("publisherid")
    private int publisherId;

    @Getter
    @Expose
    @SerializedName("description")
    private int description;

    @Getter
    @Expose
    @SerializedName("price")
    private int price;

    @Getter
    @Expose
    @SerializedName("ebookfile")
    private int ebookFile;
}
