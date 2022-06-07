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
public class RecentBook {
    @Getter
    @Expose
    @SerializedName("id")
    private UUID user_id;

    @Getter
    @Expose
    @SerializedName("id")
    private UUID book_id;
}
