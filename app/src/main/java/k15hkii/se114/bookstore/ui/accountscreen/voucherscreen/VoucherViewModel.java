package k15hkii.se114.bookstore.ui.accountscreen.voucherscreen;

import androidx.databinding.Bindable;
import k15hkii.se114.bookstore.data.model.api.User;
import k15hkii.se114.bookstore.data.model.api.Voucher;
import k15hkii.se114.bookstore.data.model.api.VoucherProfile;
import k15hkii.se114.bookstore.data.model.api.WildVoucher;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewNavigator;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;

public class VoucherViewModel extends BaseViewModel<VoucherViewNavigator> {

    @Inject protected ModelRemote remote;

    private String voucherProfileId;
//    private Voucher voucher;
//    private WildVoucher wildVoucher;

    private VoucherProfile profile;
    private Voucher voucher;
    private User user;

    public void setVoucherProfileId(String id) {
//        remote.getVoucher().doOnSuccess(voucher -> {
//            this.voucher = voucher;
//        }).subscribe();
        remote.getVoucherProfile(id).doOnSuccess(voucherProfile -> {
            profile = voucherProfile;
        }).subscribe();

        //TODO: lay voucher tu profileId va userId
    }

    @Bindable
    @Getter @Setter private String title;

    public VoucherViewModel(String title) {
        super(null);
        this.title = title;
    }
}
