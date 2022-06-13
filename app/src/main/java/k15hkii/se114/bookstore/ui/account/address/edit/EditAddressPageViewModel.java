package k15hkii.se114.bookstore.ui.account.address.edit;

import android.util.Log;
import androidx.databinding.Observable;
import k15hkii.se114.bookstore.data.remote.LocationRepository;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.di.UserId;
import k15hkii.se114.bookstore.ui.account.address.BaseAddressUpdateViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Setter;

import java.util.UUID;

public class EditAddressPageViewModel extends BaseAddressUpdateViewModel<EditAddressPageNavigator> implements Observable {

    public void Accept() {
        dispose(remote.updateAddress(userId, subId, toRequest()), result -> {

        }, throwable -> {
            Log.d(getClass().getSimpleName(), "Error: " + throwable.getMessage());
        });
    }

    @Setter
    private long subId;

    private final ModelRemote remote;
    private final UUID userId;

    public EditAddressPageViewModel(SchedulerProvider schedulerProvider, LocationRepository locationRepository, ModelRemote remote, @UserId UUID userId) {
        super(schedulerProvider, locationRepository);
        this.remote = remote;
        this.userId = userId;
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

}
