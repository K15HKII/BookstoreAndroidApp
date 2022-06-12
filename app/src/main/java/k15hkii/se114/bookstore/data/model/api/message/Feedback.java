package k15hkii.se114.bookstore.data.model.api.message;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

public class Feedback extends Message {

    @Getter
    @Expose
    @SerializedName("bill_id")
    private int billId;

    @Getter
    @Expose
    @SerializedName("replies")
    private List<ReplyFeedback> replies;

    @Getter
    @Expose
    @SerializedName("rating")
    private double rating;

}
