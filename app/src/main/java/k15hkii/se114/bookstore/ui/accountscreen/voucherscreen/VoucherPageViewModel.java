package k15hkii.se114.bookstore.ui.accountscreen.voucherscreen;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

public class VoucherPageViewModel extends BaseViewModel<VoucherPageNavigator> implements Observable {

    PreferencesHelper preferencesHelper;
    @Inject protected ModelRemote remote;
    public final ObservableField<List<VoucherViewModel>> listVoucher = new ObservableField<>();
    private UUID userId;
//    public void getData() {
//        getCompositeDisposable().add(remote.getVoucherProfiles(userId)
//                                           .subscribeOn(getSchedulerProvider().io())
//                                           .observeOn(getSchedulerProvider().ui())
//                                           .subscribe(voucherProfiles -> {
//                                               List<VoucherViewModel> list = new ArrayList<>();
//                                               for (VoucherProfile voucherProfile : voucherProfiles) {
//                                                   VoucherViewModel model = new VoucherViewModel(remote);
//                                                   model.setVoucher(voucher);
//                                                   list.add(model);
//                                               }
//                                               listVoucher.set(list);
//                                           }, throwable -> {
//                                               Log.d("VoucherPageViewModel", "getData: " + throwable.getMessage(), throwable);
//                                           }));
//    }

    public void setUserId() {
        this.userId = preferencesHelper.getCurrentUserId();
//        getData();
    }

    public VoucherPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.remote = remote;
        this.preferencesHelper = preferencesHelper;
        setUserId();
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
