package k15hkii.se114.bookstore.ui.account.address.add;

import android.util.Log;
import androidx.databinding.Observable;
import k15hkii.se114.bookstore.data.remote.LocationRepository;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.di.UserId;
import k15hkii.se114.bookstore.ui.account.address.BaseAddressUpdateViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import java.util.UUID;

public class AddAddressPageViewModel extends BaseAddressUpdateViewModel<AddAddressPageNavigator> implements Observable {

    public void Accept() {
        dispose(remote.createAddress(userId, toRequest()),
                result -> {

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
