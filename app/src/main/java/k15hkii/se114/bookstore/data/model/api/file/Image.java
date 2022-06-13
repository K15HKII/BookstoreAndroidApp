package k15hkii.se114.bookstore.data.model.api.file;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.io.Serializable;

public class Image extends File implements Serializable {
    @Getter
    @Expose
    @SerializedName("width")
    private double width;

    @Getter
    @Expose
    @SerializedName("height")
    private double height;

}
