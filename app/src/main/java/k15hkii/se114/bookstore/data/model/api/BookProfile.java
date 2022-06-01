package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;
import java.util.UUID;

@With
@AllArgsConstructor
@NoArgsConstructor
public class BookProfile {
    @Getter
    @Expose
    @SerializedName("id")
    private UUID id;

    @Getter
    @Expose
    @SerializedName("name")
    private String name;

    @Getter
    @Expose
    @SerializedName("tags")
    private List<String> tags;

    @Getter
    @Expose
    @SerializedName("authorid")
    private int authorId;

    @Getter
    @Expose
    @SerializedName("publisherid")
    private String publisherId;

    @Getter
    @Expose
    @SerializedName("description")
    private String description;

    @Getter
    @Expose
    @SerializedName("price")
    private double price;

    @Getter
    @Expose
    @SerializedName("ebookfile")
    private String ebookFile;
}
