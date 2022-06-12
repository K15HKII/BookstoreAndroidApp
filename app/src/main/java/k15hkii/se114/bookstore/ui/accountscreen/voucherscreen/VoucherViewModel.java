package k15hkii.se114.bookstore.ui.accountscreen.voucherscreen;

import android.util.Log;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.model.api.voucher.Voucher;
import k15hkii.se114.bookstore.data.model.api.voucher.VoucherProfile;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class VoucherViewModel extends BaseViewModel<VoucherViewNavigator> implements Observable {

    @Inject
    protected ModelRemote remote;
    public final ObservableField<String> discount = new ObservableField<>();
    public final ObservableField<String> discountType = new ObservableField<>();
    public final ObservableField<String> minValue = new ObservableField<>();
    public final ObservableField<String> requireBook = new ObservableField<>();
    public final ObservableField<String> bookType = new ObservableField<>();
    public final ObservableField<String> expiredDate = new ObservableField<>();

    private VoucherProfile voucherProfile;
    private Voucher voucher;
    private User user;
    private String maxCondition;

    public void getData() {
        dispose(remote.getVoucherProfile(voucher.getProfileId()), voucherProfile -> {
                    this.voucherProfile = voucherProfile;
                    this.discount.set(String.valueOf(voucherProfile.getDiscount()));
                    this.discountType.set("Giảm giá theo %");
                    this.minValue.set("Đơn hàng tối thiểu " + String.valueOf(voucherProfile.getMinValue()) + " đ");
                    this.requireBook.set("Cần tối thiểu " + String.valueOf(voucherProfile.getRequire_book()) + " quyển sách");
                    this.bookType.set("chim nhỏ, mông bự");
                }, throwable -> {
                    Log.d("VoucherViewModel", "getData: " + throwable.getMessage(), throwable);
                });
    }

    public VoucherViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
        this.expiredDate.set(String.valueOf(voucher.getExpired_at()));
        getData();
    }

}
