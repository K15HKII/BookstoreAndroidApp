package k15hkii.se114.bookstore.ui.address.recycleViewAddressSelector;

import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;

public class OtherAddressViewModel extends BaseViewModel<IOtherAddressNavigator> {
    @Inject
    protected ModelRemote remote;

    public final ObservableField<String> address = new ObservableField<>();

    public OtherAddressViewModel(String address) {
        super(null);
        this.address.set(address);
    }
}
