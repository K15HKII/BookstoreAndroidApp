package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.UUID;

public class Image extends File{
    @Getter
    @Expose
    @SerializedName("width")
    private Number width;

    @Getter
    @Expose
    @SerializedName("height")
    private Number height;
}
