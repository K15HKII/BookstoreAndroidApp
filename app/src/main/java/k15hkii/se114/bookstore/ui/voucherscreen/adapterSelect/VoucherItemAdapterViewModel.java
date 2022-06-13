package k15hkii.se114.bookstore.ui.voucherscreen.adapterSelect;

import android.util.Log;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.voucher.Voucher;
import k15hkii.se114.bookstore.data.model.api.voucher.VoucherProfile;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.voucherscreen.BaseVoucherViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;

public class VoucherItemAdapterViewModel extends BaseVoucherViewModel<VoucherItemNavigator> {

    public final ObservableBoolean isSelected = new ObservableBoolean();

    public VoucherItemAdapterViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider, remote);
    }

}
