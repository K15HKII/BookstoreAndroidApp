package k15hkii.se114.bookstore.data.model.api.file;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import k15hkii.se114.bookstore.data.model.api.file.File;
import lombok.Getter;

public class Document extends File {
    @Getter
    @Expose
    @SerializedName("size")
    private double size;
}
