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
    public final ObservableField<String> userName = new ObservableField<>();
    public final ObservableField<String> bankName = new ObservableField<>();
    public final ObservableField<String> ban = new ObservableField<>();

    @Inject
    protected ModelRemote remote;
    PreferencesHelper preferencesHelper;

    UserBank bank;
    UUID userId;
    User user;

    public void getData(UUID userId) {
        getCompositeDisposable().add(remote.getBanks(userId)
           .subscribeOn(getSchedulerProvider().io())
           .observeOn(getSchedulerProvider().ui())
           .subscribe(banks -> {
               List<OtherBankViewModel> list = new ArrayList<>();
               for (UserBank bank : banks) {
                   OtherBankViewModel model = new OtherBankViewModel();
                   model.setBank(bank);
                   list.add(model);
                   if(bank.isPrimary()){
                       bankName.set(bank.getBankName());
                       ban.set(bank.getIban());
                   }
               }
               listBanks.set(list);
           }, throwable -> {
               Log.d("BankPageViewModel", "getData: " + throwable.getMessage(), throwable);
           }));
    }


    public SelectorBankPageViewModel(SchedulerProvider schedulerProvider, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.preferencesHelper = preferencesHelper;
        this.userId = preferencesHelper.getCurrentUserId();
        userName.set(preferencesHelper.getCurrentUserName());
        getData(userId);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    public void onOpenAddBankClick(){
        getNavigator().openAddBankAccount();
    }

}
