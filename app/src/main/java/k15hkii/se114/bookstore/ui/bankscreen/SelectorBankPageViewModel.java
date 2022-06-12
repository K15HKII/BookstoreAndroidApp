package k15hkii.se114.bookstore.ui.bankscreen;

import android.util.Log;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.model.api.user.UserBank;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.bankscreen.recycleViewBankSelector.OtherBankViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SelectorBankPageViewModel extends BaseViewModel<SelectorBankPageNavigator> implements Observable {

    public final ObservableField<List<OtherBankViewModel>> listBanks = new ObservableField<>();

    protected ModelRemote remote;
    PreferencesHelper preferencesHelper;

    public final ObservableField<UserBank> bank = new ObservableField<>();
    public final ObservableField<String> bankName = new ObservableField<>();
    public final ObservableField<String> iBan = new ObservableField<>();
    private final UUID userId;
    private User user;
    public final ObservableField<String> userName = new ObservableField<>();

    public void getData(UUID userId) {
        dispose(remote.getBanks(userId),
                banks -> {
                    List<OtherBankViewModel> list = new ArrayList<>();
                    for (UserBank bank : banks) {
                        if (bank.isPrimary()) {
                            this.bank.set(bank);
                            bankName.set(bank.getBankName());
                            iBan.set(bank.getIban());
                        } else {
                            OtherBankViewModel model = new OtherBankViewModel();
                            model.setBank(bank);
                            list.add(model);
                        }
                    }
                    listBanks.set(list);
                }, throwable -> {
                    Log.d("BankPageViewModel", "getData: " + throwable.getMessage(), throwable);
                });

        dispose(remote.getUser(userId), user -> {
            this.user = user;
            this.userName.set(user.getName());
        }, throwable -> {
            Log.d("User", "getData: " + throwable.getMessage(), throwable);
        });
    }

    public SelectorBankPageViewModel(SchedulerProvider schedulerProvider, PreferencesHelper preferencesHelper, ModelRemote remote) {
        super(schedulerProvider);
        this.preferencesHelper = preferencesHelper;
        this.userId = preferencesHelper.getCurrentUserId();
        this.remote = remote;
        getData(userId);
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

    public void onOpenAddBankClick() {
        getNavigator().openAddBankAccount();
    }

}
