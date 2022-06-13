package k15hkii.se114.bookstore.ui.account.address.recycleViewAddressSelector;

import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.user.UserAddress;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

public class OtherAddressViewModel extends BaseViewModel<IOtherAddressNavigator> {

    public final ObservableField<UserAddress> address = new ObservableField<>();

    public OtherAddressViewModel() {
        super(null);
    }

    public void setAddress(UserAddress address) {
        this.address.set(address);
    }

}
