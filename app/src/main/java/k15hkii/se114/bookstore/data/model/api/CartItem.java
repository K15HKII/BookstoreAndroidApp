package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class CartItem {
    @Getter
    @Expose
    @SerializedName("userid")
    private String userid;

    @Getter
    @Expose
    @SerializedName("bookprofileid")
    private String bookProfileid;

    @Getter
    @Expose
    @SerializedName("selected")
    private int selected;
}
