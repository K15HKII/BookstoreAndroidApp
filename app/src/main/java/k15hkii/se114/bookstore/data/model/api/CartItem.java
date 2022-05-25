package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class CartItem {
    @Getter
    @Expose
    @SerializedName("userid")
    private int userid;

    @Getter
    @Expose
    @SerializedName("bookprofile")
    private int bookProfile;

    @Getter
    @Expose
    @SerializedName("selected")
    private int selected;
}
