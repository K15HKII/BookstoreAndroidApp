package k15hkii.se114.bookstore.ui.bankscreen.recycleViewBankSelector;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.User;
import k15hkii.se114.bookstore.data.model.api.UserBank;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.UUID;

public class OtherBankViewModel extends BaseViewModel<IOtherBankNavigator> implements Observable {
    @Inject
    protected ModelRemote remote;

    UserBank bank;
    User user;

    private void setUser(UUID userId) {
            getCompositeDisposable().add(remote.getUser(userId)
                   .subscribeOn(getSchedulerProvider().io())
                   .observeOn(getSchedulerProvider().ui())
                   .doOnSuccess(user -> {
                       this.user = user;
                   }).subscribe());
    }

    @Bindable
    public String getName() {
        return user == null ? "profile is null" : user.getUserName();
    }

    @Bindable
    public String getBankAccountNumber() {
        return bank == null ? "profile is null" : bank.getIban();
    }

    @Bindable
    public String getBankName() {
        return bank == null ? "profile is null" : bank.getBankName();
    }

    public OtherBankViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }
    public OtherBankViewModel() {
        super(null);
    }

    public void setBank(UserBank bank, UUID userId) {
        this.bank = bank;
        setUser(userId);
    }
}
