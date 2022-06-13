package k15hkii.se114.bookstore.data.model.api.message;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

public class ReplyCRUDRequest extends MessageCRUDRequest {

    public ReplyCRUDRequest(List<UUID> images, List<UUID> videos, String text, UUID feedbackId) {
        super(images, videos, text);
        this.feedbackId = feedbackId;
    }

    @Expose
    @SerializedName("feedback_id")
    @Getter
    private UUID feedbackId;

}
