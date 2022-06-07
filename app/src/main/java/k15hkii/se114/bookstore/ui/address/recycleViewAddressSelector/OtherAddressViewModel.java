package k15hkii.se114.bookstore.ui.address.recycleViewAddressSelector;

import androidx.databinding.Bindable;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.model.api.user.UserAddress;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;

public class OtherAddressViewModel extends BaseViewModel<IOtherAddressNavigator> {
    @Inject
    protected ModelRemote remote;

    UserAddress address;
    User user;

    public OtherAddressViewModel() {
        super(null);
    }
//
//    private void getData(UUID userId) {
//        getCompositeDisposable().add(remote.getUser(userId)
//                                           .subscribeOn(getSchedulerProvider().io())
//                                           .observeOn(getSchedulerProvider().ui())
//                                           .doOnSuccess(user -> {
//                                               this.user = user;
//                                           }).subscribe());
//    }

    @Bindable
    public String getAddress() {
        return address == null ? "profile is null" : address.getCity();
    }

    public void setAddress(UserAddress address) {
        this.address = address;
    }
}
