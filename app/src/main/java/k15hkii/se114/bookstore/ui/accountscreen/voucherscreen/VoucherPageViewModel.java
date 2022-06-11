package k15hkii.se114.bookstore.ui.accountscreen.voucherscreen;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.voucher.VoucherProfile;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VoucherPageViewModel extends BaseViewModel<VoucherPageNavigator> implements Observable {


    public final ObservableField<List<VoucherViewModel>> listVoucher = new ObservableField<>();
    protected ViewModelMapper mapper;
    private UUID userId;

    public void getData(UUID userId) {
        dispose(mapper.getVouchers(userId),
                listVoucher::set,
                throwable -> Log.d("VoucherPageViewModel", "getData: " + throwable.getMessage(), throwable));
    }


    public VoucherPageViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.mapper = mapper;
        this.userId = preferencesHelper.getCurrentUserId();
        getData(userId);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

}
