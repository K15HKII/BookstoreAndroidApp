package k15hkii.se114.bookstore.ui.voucher;

import android.util.Log;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.voucher.Voucher;
import k15hkii.se114.bookstore.data.model.api.voucher.VoucherProfile;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.base.INavigator;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Getter;

public class BaseVoucherViewModel<N extends INavigator> extends BaseViewModel<N> {

    public BaseVoucherViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
    }

    @Getter
    protected ModelRemote remote;
    public final ObservableField<String> discount = new ObservableField<>();
    public final ObservableField<String> discountType = new ObservableField<>();
    public final ObservableField<String> minValue = new ObservableField<>();
    public final ObservableField<String> requireBook = new ObservableField<>();
    public final ObservableField<String> bookType = new ObservableField<>();
    public final ObservableField<String> expiredDate = new ObservableField<>();

    private VoucherProfile voucherProfile;
    @Getter
    private Voucher voucher;

    public void getData() {
        dispose(remote.getVoucherProfile(voucher.getProfileId()), voucherProfile -> {
            this.voucherProfile = voucherProfile;
            this.discount.set(String.valueOf(voucherProfile.getDiscount()));
            this.discountType.set("Giảm giá theo %");
            this.minValue.set("Đơn hàng tối thiểu " + voucherProfile.getMinValue() + " đ");
            this.requireBook.set("Cần tối thiểu " + voucherProfile.getRequire_book() + " quyển sách");
            this.bookType.set("Hài hước");
        }, throwable -> {
            Log.d("VoucherViewModel", "getData: " + throwable.getMessage(), throwable);
        });
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
        this.expiredDate.set(String.valueOf(voucher.getExpiredAt()));
        getData();
    }

}
