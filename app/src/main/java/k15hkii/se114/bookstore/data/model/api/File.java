package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.UUID;

@With
@AllArgsConstructor
@NoArgsConstructor
public class File {
    @Getter
    @Expose
    @SerializedName("id")
    private UUID id;

    @Getter
    @Expose
    @SerializedName("name")
    private String name;

    @Getter
    @Expose
    @SerializedName("path")
    private String path;

}

