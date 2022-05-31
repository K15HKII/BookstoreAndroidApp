package k15hkii.se114.bookstore.data.model.api;

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
public class Book {
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
    @SerializedName("quantity")
    private Number quantity;

    @Getter
    @Expose
    @SerializedName("author")
    private Author author;

    @Getter
    @Expose
    @SerializedName("price")
    private Number price;

    @Getter
    @Expose
    @SerializedName("publisher")
    private Publisher publisher;

    @Getter
    @Expose
    @SerializedName("images")
    private Image[] images;

    @Getter
    @Expose
    @SerializedName("videos")
    private Video[] videos;

    @Getter
    @Expose
    @SerializedName("ebook")
    private Document[] ebook;

    @Getter
    @Expose
    @SerializedName("feedbacks")
    private Feedback[] feedbacks;
}
