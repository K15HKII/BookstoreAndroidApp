package k15hkii.se114.bookstore.ui.address.add;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import k15hkii.se114.bookstore.data.model.api.user.UserAddressCRUDRequest;
import k15hkii.se114.bookstore.data.model.location.*;
import k15hkii.se114.bookstore.data.remote.LocationRepository;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.di.UserId;
import k15hkii.se114.bookstore.ui.address.AddressHelper;
import k15hkii.se114.bookstore.ui.address.BaseAddressUpdateViewModel;
import k15hkii.se114.bookstore.utils.SpinnerWrapper;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import java.util.List;
import java.util.UUID;

public class AddAddressPageViewModel extends BaseAddressUpdateViewModel<AddAddressPageNavigator> implements Observable {

    public final ObservableField<String> addressNumber = new ObservableField<>();
    public final ObservableField<Boolean> defaultAddress = new ObservableField<>();

    public void Accept() {
        UserAddressCRUDRequest request = new UserAddressCRUDRequest(); //TODO: create
        dispose(remote.createAddress(userId, request),
                result -> {
                    //TODO:
                }, throwable -> {
                    Log.d("AddAddressPageViewModel", "Error: " + throwable.getMessage());
                });
    }

    private final ModelRemote remote;
    private final UUID userId;

    public AddAddressPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, LocationRepository locationRepository, @UserId UUID userId) {
        super(schedulerProvider, locationRepository);
        this.remote = remote;
        this.userId = userId;
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

}
