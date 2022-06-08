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
    @SerializedName("stock")
    private int stock;

    @Getter
    @Expose
    @SerializedName("author_id")
    private int authorId;

    @Getter
    @Expose
    @SerializedName("price")
    private int price;

    @Getter
    @Expose
    @SerializedName("publisher_id")
    private int publisher;

    @Getter
    @Expose
    @SerializedName("book_tag")
    private BookTag[] booktags;
}
