package k15hkii.se114.bookstore.data.model.api.bill;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import k15hkii.se114.bookstore.data.model.api.Payment;
import k15hkii.se114.bookstore.data.model.api.cartitem.CartItemCRUDRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

public class BillCreateRequest {

    @Expose
    @Getter
    @Setter
    @SerializedName("items")
    private List<CartItemCRUDRequest> items;

    @Expose
    @Getter
    @Setter
    @SerializedName("address_id")
    private long addressId;

    @Expose
    @Getter
    @Setter
    @SerializedName("bank_id")
    private long bankId;

    @Expose
    @Getter
    @Setter
    @SerializedName("payment")
    private Payment payment;

    @Expose
    @Getter
    @Setter
    @SerializedName("vouchers")
    private List<UUID> vouchers;

}
