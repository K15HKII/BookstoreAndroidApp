package k15hkii.se114.bookstore.ui.bankscreen.add;

import android.util.Log;
import androidx.databinding.Observable;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.di.UserId;
import k15hkii.se114.bookstore.ui.bankscreen.BaseBankUpdateViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import java.util.UUID;

public class AddBankPageViewModel extends BaseBankUpdateViewModel<AddBankPageNavigator> implements Observable {

    public void Accept() {
        dispose(remote.createBank(userId, toRequest()),
                bank -> {

                }, throwable -> {
                    Log.d("AddBankPageViewModel", throwable.getMessage());
                });
    }

    private final ModelRemote remote;
    private final UUID userId;

    public AddBankPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, @UserId UUID userId) {
        super(schedulerProvider);
        this.remote = remote;
        this.userId = userId;
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

}
