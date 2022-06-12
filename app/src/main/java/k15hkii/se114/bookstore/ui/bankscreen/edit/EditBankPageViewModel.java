package k15hkii.se114.bookstore.ui.bankscreen.edit;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.di.UserId;
import k15hkii.se114.bookstore.ui.bankscreen.BaseBankUpdateViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
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
    @Setter private long subId;

    public EditBankPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, @UserId UUID userId) {
        super(schedulerProvider);
        this.remote = remote;
        this.userId = userId;
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

}
