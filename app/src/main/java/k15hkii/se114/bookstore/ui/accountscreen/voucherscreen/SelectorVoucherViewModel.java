package k15hkii.se114.bookstore.ui.accountscreen.voucherscreen;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import java.util.List;

public class SelectorVoucherViewModel extends BaseViewModel<SelectorVoucherNavigator> {
    public final ObservableField<List<VoucherViewModel>> listVoucher = new ObservableField<>();

    public SelectorVoucherViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }
    public void onBackWardClick() {
        getNavigator().BackWard();
    }
}
