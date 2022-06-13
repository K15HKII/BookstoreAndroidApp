package k15hkii.se114.bookstore.ui.voucherscreen;

import android.util.Log;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.voucherscreen.adapterSelect.VoucherItemAdapterViewModel;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

public class SelectorVoucherViewModel extends BaseViewModel<SelectorVoucherNavigator> {

    public final ObservableField<List<VoucherItemAdapterViewModel>> items = new ObservableField<>();

    @Inject protected ViewModelMapper mapper;

    UUID userId;

    public void getData() {
        dispose(mapper.getSelectVouchers(userId),
                items::set,
                throwable -> Log.d("SelectVoucherViewModel", "getData: " + throwable.getMessage(), throwable));
    }

    public SelectorVoucherViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper helper) {
        super(schedulerProvider);
        this.mapper = mapper;
        this.userId = helper.getCurrentUserId();
    }
    public void onBackWardClick() {
        getNavigator().BackWard();
    }
}
