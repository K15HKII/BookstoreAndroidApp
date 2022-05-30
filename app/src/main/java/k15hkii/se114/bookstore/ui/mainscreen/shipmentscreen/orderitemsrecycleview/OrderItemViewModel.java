package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview;

import androidx.databinding.Bindable;
import k15hkii.se114.bookstore.data.model.api.BillDetail;
import k15hkii.se114.bookstore.data.model.api.BookProfile;
import k15hkii.se114.bookstore.data.model.api.BookProfileImage;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;

public class OrderItemViewModel extends BaseViewModel<OrderItemNavigator> {

    @Inject protected ModelRemote remote;

    private BillDetail billDetail;
    private BookProfile bookProfile;
    private int bookImage;
    private String billId;
    private String bookProfileId;

    public void setBillDetail(BillDetail billDetail) {
        this.billDetail = billDetail;

        remote.getBookprofile(String.valueOf(billDetail.getBookId())).doOnSuccess(bookProfile -> {
            this.bookProfile = bookProfile;
            bookProfileId = String.valueOf(bookProfile.getId());
        }).subscribe();

        remote.getBookprofileimage(bookProfileId, 1).doOnSuccess(bookProfileImage -> {
            this.bookImage = bookProfileImage.getImage();
        }).subscribe();
    }

    @Bindable
    @Getter
    @Setter
    private String Name;

    public OrderItemViewModel(String name) {
        super(null);
        this.Name = name;
    }
}