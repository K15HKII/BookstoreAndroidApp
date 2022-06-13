package k15hkii.se114.bookstore.ui.voucher.adapter;

import androidx.databinding.ObservableBoolean;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.voucher.BaseVoucherViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class VoucherItemAdapterViewModel extends BaseVoucherViewModel<VoucherItemNavigator> {

    public final ObservableBoolean isSelected = new ObservableBoolean();

    public VoucherItemAdapterViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider, remote);
    }

}
