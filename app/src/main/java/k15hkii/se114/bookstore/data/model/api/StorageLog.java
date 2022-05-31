package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.UUID;

public class StorageLog {

    @Getter
    @Expose
    @SerializedName("id")
    private UUID id;

    @Getter
    @Expose
    @SerializedName("description")
    private String description;

    @Getter
    @Expose
    @SerializedName("action")
    private String action;

    @Getter
    @Expose
    @SerializedName("details")
    private StorageLogDetail[] details;
}

