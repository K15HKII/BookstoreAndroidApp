package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class Audio extends File{
    @Getter
    @Expose
    @SerializedName("duration")
    private Number duration;
}
