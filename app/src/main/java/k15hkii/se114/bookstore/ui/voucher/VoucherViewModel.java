package k15hkii.se114.bookstore.ui.voucher;

import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class VoucherViewModel extends BaseVoucherViewModel<VoucherViewNavigator> {

    public VoucherViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider, remote);
    }

}
