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

    @Inject
    protected ModelRemote remote;
    PreferencesHelper preferencesHelper;

    UserBank bank;
    String bankName;
    String userName;
    String ban;
    UUID userId;
    User user;

    public void getData() {
        getCompositeDisposable().add(remote.getBanks(userId)
           .subscribeOn(getSchedulerProvider().io())
           .observeOn(getSchedulerProvider().ui())
           .subscribe(banks -> {
               List<OtherBankViewModel> list = new ArrayList<>();
               for (UserBank bank : banks) {
                   OtherBankViewModel model = new OtherBankViewModel();
                   model.setBank(bank);
                   list.add(model);
                   //Todo: get primary bank
               }
               listBanks.set(list);
           }, throwable -> {
               Log.d("BankPageViewModel", "getData: " + throwable.getMessage(), throwable);
           }));

        getCompositeDisposable().add(remote.getUser(userId)
                                           .subscribeOn(getSchedulerProvider().io())
                                           .observeOn(getSchedulerProvider().ui())
                                           .subscribe(user -> {
                                               this.user = user;
                                           }, throwable -> {
                                               Log.d("User", "getData: " + throwable.getMessage(), throwable);
                                           }));
    }

    public void setUserId() {
        this.userId = preferencesHelper.getCurrentUserId();
    }
    @Bindable
    public String getBankName() {
        return bankName == null ? "profile is null" : bank.getBankName();
    }
    @Bindable
    public String getUserName() {
        return userName == null ? "profile is null" : user.getUserName();
    }
    @Bindable
    public String getBan() {
        return ban == null ? "profile is null" : bank.getIban();
    }


    public SelectorBankPageViewModel(SchedulerProvider schedulerProvider, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.preferencesHelper = preferencesHelper;
        setUserId();
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    public void onOpenAddBankClick(){
        getNavigator().openAddBankAccount();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
