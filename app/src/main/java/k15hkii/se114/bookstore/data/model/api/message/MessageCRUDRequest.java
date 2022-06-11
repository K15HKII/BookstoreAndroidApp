package k15hkii.se114.bookstore.data.model.api.message;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

public class MessageCRUDRequest {

    public MessageCRUDRequest(List<UUID> images, List<UUID> videos, String text) {
        this.images = images;
        this.videos = videos;
        this.text = text;
    }

    @Expose
    @SerializedName("images")
    @Getter
    private List<UUID> images;

    @Expose
    @SerializedName("videos")
    @Getter
    private List<UUID> videos;

    @Expose
    @SerializedName("text")
    @Getter
    private String text;

}
