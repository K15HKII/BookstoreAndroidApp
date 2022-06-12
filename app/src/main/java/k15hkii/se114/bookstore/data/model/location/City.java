package k15hkii.se114.bookstore.data.model.location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

public class City {

    @Expose
    @Getter
    @SerializedName("id")
    private int id;

    @Expose
    @Getter
    @SerializedName("code")
    private String code;

    @Expose
    @Getter
    @SerializedName("name")
    private String name;

    @Expose
    @Getter
    @SerializedName("districts")
    private List<District> districts;

}
