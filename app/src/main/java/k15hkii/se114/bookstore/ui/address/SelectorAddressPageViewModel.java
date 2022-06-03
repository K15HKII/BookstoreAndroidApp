package k15hkii.se114.bookstore.ui.address;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.UserAddress;
import k15hkii.se114.bookstore.data.model.api.UserBank;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.address.recycleViewAddressSelector.OtherAddressViewModel;
import k15hkii.se114.bookstore.ui.bankscreen.recycleViewBankSelector.OtherBankViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class SelectorAddressPageViewModel extends BaseViewModel<SelectorAddressPageNavigator> implements Observable {

    public final ObservableField<List<OtherAddressViewModel>> listAddress = new ObservableField<>();

    @Inject
    protected ModelRemote remote;

//    private String userId;
//    private String index;
//    private UserAddress userAddress;
//
//    public void setUserAddress(String id, String index) {
//        this.userId = id;
//        this.index = index;
//        remote.getUseraddress(id,index).doOnSuccess(userAddress -> {
//            this.userAddress = userAddress;
//        }).subscribe();
//    }

    public void getData(UUID userId) {
        getCompositeDisposable().add(remote.getAddresses(userId)
                                           .subscribeOn(getSchedulerProvider().io())
                                           .observeOn(getSchedulerProvider().ui())
                                           .subscribe(addresses -> {
                                               List<OtherAddressViewModel> list = new ArrayList<>();
                                               for (UserAddress address : addresses) {
                                                   OtherAddressViewModel model = new OtherAddressViewModel();
                                                   model.setAddress(address, userId.toString());
                                                   list.add(model);
                                               }
                                               listAddress.set(list);
                                           }, throwable -> {
                                               Log.d("BankPageViewModel", "getData: " + throwable.getMessage(), throwable);
                                           }));
    }

    public SelectorAddressPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    public void onOpenAddBankClick(){
        getNavigator().openAddBank();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
