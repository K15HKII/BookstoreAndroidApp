package k15hkii.se114.bookstore.ui.address.recycleViewAddressSelector;

import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.User;
import k15hkii.se114.bookstore.data.model.api.UserAddress;
import k15hkii.se114.bookstore.data.model.api.UserBank;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;
import java.util.UUID;

public class OtherAddressViewModel extends BaseViewModel<IOtherAddressNavigator> {
    @Inject
    protected ModelRemote remote;

    UserAddress address;
    User user;

    public OtherAddressViewModel() {
        super(null);
    }

    private void setUser(UUID userId) {
        getCompositeDisposable().add(remote.getUser(userId)
                                           .subscribeOn(getSchedulerProvider().io())
                                           .observeOn(getSchedulerProvider().ui())
                                           .doOnSuccess(user -> {
                                               this.user = user;
                                           }).subscribe());
    }

    @Bindable
    public String getAddress() {
        return address == null ? "profile is null" : address.getCity();
    }

    public OtherAddressViewModel(UserAddress address, UUID userId) {
        super(null);
        this.address = address;
        setUser(userId);
    }

    public void setAddress(UserAddress address, UUID userId) {
        this.address = address;
        setUser(userId);
    }
}
