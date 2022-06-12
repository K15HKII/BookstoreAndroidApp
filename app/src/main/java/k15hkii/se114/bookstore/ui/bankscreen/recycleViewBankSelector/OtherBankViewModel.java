package k15hkii.se114.bookstore.ui.bankscreen.recycleViewBankSelector;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.model.api.user.UserBank;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.UUID;

public class OtherBankViewModel extends BaseViewModel<IOtherBankNavigator> implements Observable {

    @Inject
    protected ModelRemote remote;
    public final ObservableField<String> userName = new ObservableField<>();
    public final ObservableField<String> iban = new ObservableField<>();
    public final ObservableField<String> bankName = new ObservableField<>();
    UserBank bank;
    User user;
    long bankId;
    UUID userId;

    public void getData(UUID userId, long BankId) {
        getCompositeDisposable().add(remote.getSelfUser()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .doOnSuccess(user -> {
                    this.user = user;
                    this.userName.set(user.getFirstName() + " " + user.getLastName());
                }).subscribe());
        getCompositeDisposable().add(remote.getBank(userId,bankId)
                                           .subscribeOn(getSchedulerProvider().io())
                                           .observeOn(getSchedulerProvider().ui())
                                           .doOnSuccess(bank -> {
                                               this.bank = bank;
                                               this.iban.set(String.valueOf(bank.getIban()));
                                               this.bankName.set(String.valueOf(bank.getBankName()));
                                           }).subscribe());
    }


    public OtherBankViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper helper) {
        super(schedulerProvider);
        this.remote = remote;
        this.userId = helper.getCurrentUserId();
        getData(userId,bank.getSubId());
    }
    public OtherBankViewModel() {
        super(null);
    }

    public void setBank(UserBank bank) {
        this.bank = bank;
    }
}
