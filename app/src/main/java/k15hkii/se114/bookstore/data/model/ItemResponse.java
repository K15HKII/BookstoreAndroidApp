package k15hkii.se114.bookstore.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class ItemResponse<T> extends StatusResponse {

    @Expose
    @SerializedName("item")
    @Getter
    private T item;

}
