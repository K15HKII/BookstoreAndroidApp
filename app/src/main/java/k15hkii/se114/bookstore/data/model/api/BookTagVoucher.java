package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.UUID;

public class BookTagVoucher extends VoucherProfile{
    @Getter
    @Expose
    @SerializedName("tag")
    private String tag;
}
