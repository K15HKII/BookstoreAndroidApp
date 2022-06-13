package k15hkii.se114.bookstore.ui.account.bank.edit;

import android.util.Log;
import androidx.databinding.Observable;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.di.UserId;
import k15hkii.se114.bookstore.ui.account.bank.BaseBankUpdateViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Setter;

import java.util.UUID;

public class EditBankPageViewModel extends BaseBankUpdateViewModel<EditBankPageNavigator> implements Observable {

    public void Accept() {
        dispose(remote.updateBank(userId, subId, toRequest()),
                bank -> {

                }, throwable -> {
                    Log.d("AddBankPageViewModel", throwable.getMessage());
                });
    }

    private final ModelRemote remote;
    private final UUID userId;
    @Setter
    private long subId;

    public EditBankPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, @UserId UUID userId) {
        super(schedulerProvider);
        this.remote = remote;
        this.userId = userId;
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

}
