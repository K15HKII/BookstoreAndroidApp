package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class Feedback extends Message{

    @Getter
    @Expose
    @SerializedName("replies")
    private ReplyFeedback[] replies;

    @Getter
    @Expose
    @SerializedName("rating")
    private Number rating;
}
