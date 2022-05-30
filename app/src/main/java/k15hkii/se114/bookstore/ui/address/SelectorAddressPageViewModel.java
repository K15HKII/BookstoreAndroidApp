package k15hkii.se114.bookstore.ui.address;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.data.model.api.BookProfile;
import k15hkii.se114.bookstore.data.model.api.BookProfileImage;
import k15hkii.se114.bookstore.data.model.api.UserAddress;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

public class SelectorAddressPageViewModel extends BaseViewModel<SelectorAddressPageNavigator> implements Observable {

    private final MutableLiveData<List<Address>> selectorAddressItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new Address("Biên Hòa, Đồng Nai"),
                          new Address("Khánh Hòa"))
    );

    @Inject
    protected ModelRemote remote;

    private String userId;
    private String index;
    private UserAddress userAddress;

    public void setUserAddress(String id, String index) {
        this.userId = id;
        this.index = index;
        remote.getUseraddress(id,index).doOnSuccess(userAddress -> {
            this.userAddress = userAddress;
        }).subscribe();
    }

    public List<Address> getAddressItems() {
        return selectorAddressItemsLiveData.getValue();
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
