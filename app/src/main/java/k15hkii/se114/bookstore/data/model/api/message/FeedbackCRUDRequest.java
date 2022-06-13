package k15hkii.se114.bookstore.data.model.api.message;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

public class FeedbackCRUDRequest extends MessageCRUDRequest {

    public FeedbackCRUDRequest(List<UUID> images, List<UUID> videos, String text, UUID bookId, double rating) {
        super(images, videos, text);
        this.bookId = bookId;
        this.rating = rating;
    }

    @Expose
    @SerializedName("book_id")
    @Getter
    private UUID bookId;

    @Expose
    @SerializedName("rating")
    @Getter
    private double rating;

}
