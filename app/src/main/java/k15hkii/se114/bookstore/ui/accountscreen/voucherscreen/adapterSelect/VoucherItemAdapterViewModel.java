package k15hkii.se114.bookstore.ui.accountscreen.voucherscreen.adapterSelect;

import k15hkii.se114.bookstore.data.model.api.Voucher;
import k15hkii.se114.bookstore.data.model.api.VoucherProfile;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.Date;

public class VoucherItemAdapterViewModel extends BaseViewModel<VoucherItemNavigator> {

    @Inject
    protected ModelRemote remote;

    private VoucherProfile voucherProfile;
    private Voucher voucher;
    private User user;
    private String discount;
    private String discountType;
    private Date expiredDate;
    private String maxCondition;

    public VoucherItemAdapterViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }
}
