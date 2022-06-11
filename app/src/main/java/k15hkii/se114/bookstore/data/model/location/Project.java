package k15hkii.se114.bookstore.data.model.location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class Project {

    @Expose
    @Getter
    @SerializedName("id")
    private int id;

    @Expose
    @Getter
    @SerializedName("name")
    private String name;

    @Expose
    @Getter
    @SerializedName("lat")
    private double lat;

    @Expose
    @Getter
    @SerializedName("lng")
    private double lng;

}
