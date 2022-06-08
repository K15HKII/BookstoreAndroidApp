package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@With
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    @Getter
    @Expose
    @SerializedName("id")
    private UUID id;

    @Getter
    @Expose
    @SerializedName("title")
    private String title;

    @Getter
    @Expose
    @SerializedName("description")
    private String description;


    @Getter
    @Expose
    @SerializedName("stock")
    private int stock;

    @Getter
    @Expose
    @SerializedName("author_id")
    private int authorId;

    @Getter
    @Expose
    @SerializedName("price")
    private double price;

    @Getter
    @Expose
    @SerializedName("publisher_id")
    private int publisher;

    @Getter
    @Expose
    @SerializedName("book_tag")
    private BookTag[] booktags;

    @Getter
    @Expose
    @SerializedName("images")
    private List<Image> images;

    @Getter
    @Expose
    @SerializedName("videos")
    private List<Video> videos;

}
