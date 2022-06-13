package k15hkii.se114.bookstore.ui.address;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.user.UserAddress;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.address.recycleViewAddressSelector.OtherAddressViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SelectorAddressPageViewModel extends BaseViewModel<SelectorAddressPageNavigator> implements Observable {

    public final ObservableField<List<OtherAddressViewModel>> listAddress = new ObservableField<>();

    @Inject
    protected ModelRemote remote;
    private final UUID userId;
    public final ObservableField<UserAddress> primaryAddress = new ObservableField<>();

    public void loadData() {
        dispose(remote.getAddresses(userId), addresses -> {
            List<OtherAddressViewModel> list = new ArrayList<>();
            for (UserAddress address : addresses) {
                if (address.isPrimary()) {
                    primaryAddress.set(address);
                } else {
                    OtherAddressViewModel model = new OtherAddressViewModel();
                    model.setAddress(address);
                    list.add(model);
                }
            }
            listAddress.set(list);
        }, throwable -> {
            Log.d("AddressPageViewModel", "getData: " + throwable.getMessage(), throwable);
        });
    }

    public SelectorAddressPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.remote = remote;
        this.userId = preferencesHelper.getCurrentUserId();
        loadData();
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

    public void onOpenAddBankClick() {
        getNavigator().openAddBank();
    }

}
