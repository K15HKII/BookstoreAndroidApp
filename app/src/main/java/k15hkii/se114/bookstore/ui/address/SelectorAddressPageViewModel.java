package k15hkii.se114.bookstore.ui.address;

import android.util.Log;
import androidx.databinding.Bindable;
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

    public final ObservableField<String> primaryAddress = new ObservableField<>();


    @Inject
    protected ModelRemote remote;
    private UUID user_id;
    public void getData(UUID userId) {
        getCompositeDisposable().add(remote.getAddresses(userId)
                                           .subscribeOn(getSchedulerProvider().io())
                                           .observeOn(getSchedulerProvider().ui())
                                           .subscribe(addresses -> {
                                               List<OtherAddressViewModel> list = new ArrayList<>();
                                               for (UserAddress address : addresses) {
                                                   OtherAddressViewModel model = new OtherAddressViewModel();
                                                   model.setAddress(address);
                                                   list.add(model);
                                                   if(address.isPrimary()){
                                                       primaryAddress.set(address.getNumber() + ", "+ address.getStreet() + ", "  + address.getCity() + ", " + address.getCountry());
                                                   }
                                               }
                                               listAddress.set(list);
                                           }, throwable -> {
                                               Log.d("AddressPageViewModel", "getData: " + throwable.getMessage(), throwable);
                                           }));
    }

    public SelectorAddressPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.remote = remote;
        this.user_id = preferencesHelper.getCurrentUserId();
        getData(user_id);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    public void onOpenAddBankClick(){
        getNavigator().openAddBank();
    }

}
