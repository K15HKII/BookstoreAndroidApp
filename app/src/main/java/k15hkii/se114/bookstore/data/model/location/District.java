package k15hkii.se114.bookstore.data.model.location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

public class District {

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
    @SerializedName("wards")
    private List<Ward> wards;

    @Expose
    @Getter
    @SerializedName("streets")
    private List<Street> streets;

    @Expose
    @Getter
    @SerializedName("projects")
    private List<Project> projects;

}
