package k15hkii.se114.bookstore.data.model.api.message;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.data.model.api.file.Video;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Message {

    @Getter
    @Expose
    @SerializedName("id")
    private UUID id;

    @Expose
    @Getter
    @SerializedName("user_id")
    private UUID userId;

    @Expose
    @Getter
    @SerializedName("created_at")
    private Date createdAt;

    @Getter
    @Expose
    @SerializedName("text")
    private String text;

    @Getter
    @Expose
    @SerializedName("images")
    private List<Image> images;

    @Getter
    @Expose
    @SerializedName("videos")
    private List<Video> videos;

}
