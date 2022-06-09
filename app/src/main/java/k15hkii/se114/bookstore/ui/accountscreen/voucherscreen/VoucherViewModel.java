package k15hkii.se114.bookstore.ui.accountscreen.voucherscreen;

import android.util.Log;
import androidx.databinding.Bindable;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.model.api.voucher.Voucher;
import k15hkii.se114.bookstore.data.model.api.voucher.VoucherProfile;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.Date;

public class VoucherViewModel extends BaseViewModel<VoucherViewNavigator> {

    @Inject
    protected ModelRemote remote;

    private VoucherProfile voucherProfile;
    private Voucher voucher;
    private User user;
    private String discount;
    private String discountType;
    private Date expiredDate;
    private String maxCondition;

    public void setData() {
        getCompositeDisposable().add(remote.getVoucherProfile(voucher.getProfileId())
                                           .subscribeOn(getSchedulerProvider().io())
                                           .observeOn(getSchedulerProvider().ui())
                                           .subscribe(voucherProfile -> {
                                               this.voucherProfile = voucherProfile;
                                           }, throwable -> {
                                               Log.d("VoucherViewModel", "getData: " + throwable.getMessage(), throwable);
                                           }));
    }

    public VoucherViewModel(ModelRemote remote) {
        super(null);
        this.remote = remote;
    }
    public VoucherViewModel(){
        super(null);
    }
    @Bindable
    public String getDiscount() {
        return voucherProfile == null ? "null" : String.valueOf(voucherProfile.getDiscount());
    }

    @Bindable
    public String getDate(){
        return voucher == null ? "null" : String.valueOf(voucher.getUsedAt());
    }

    @Bindable
    public String getMinValue(){
        return voucherProfile == null ? "null" : "Áp dụng cho đơn hàng trên " + String.valueOf(voucherProfile.getMinValue()) + "đ";
    }

    @Bindable
    public String getDiscountType(){
        return voucherProfile == null ? "null" : String.valueOf(voucherProfile.getDiscountType());
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
        setData();
    }
}
