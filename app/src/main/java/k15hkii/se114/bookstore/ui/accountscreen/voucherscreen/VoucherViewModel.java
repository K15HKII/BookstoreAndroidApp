package k15hkii.se114.bookstore.ui.accountscreen.voucherscreen;

import android.util.Log;
import androidx.databinding.Bindable;
import k15hkii.se114.bookstore.data.model.api.*;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.Date;

public class VoucherViewModel extends BaseViewModel<VoucherViewNavigator> {

    protected final ModelRemote remote;

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

    @Bindable
    public String getDiscount() {
        return discount == null ? "null" : String.valueOf(voucherProfile.getDiscount());
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
        setData();
    }
}
