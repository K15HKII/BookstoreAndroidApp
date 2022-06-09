package k15hkii.se114.bookstore.data.model.api.file;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class Image extends File {
    @Getter
    @Expose
    @SerializedName("width")
    private double width;

    @Getter
    @Expose
    @SerializedName("height")
    private double height;

}
