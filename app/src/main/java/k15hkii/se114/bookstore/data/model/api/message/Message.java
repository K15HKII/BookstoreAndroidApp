package k15hkii.se114.bookstore.data.model.api.message;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.data.model.api.file.Video;
import lombok.Getter;

import java.util.UUID;

public class Message {

    @Getter
    @Expose
    @SerializedName("id")
    private UUID id;

    @Getter
    @Expose
    @SerializedName("text")
    private String text;

    @Getter
    @Expose
    @SerializedName("images")
    private Image[] images;

    @Getter
    @Expose
    @SerializedName("videos")
    private Video[] videos;

}