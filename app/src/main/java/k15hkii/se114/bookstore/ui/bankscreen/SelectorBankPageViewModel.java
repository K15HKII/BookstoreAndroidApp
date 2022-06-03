package k15hkii.se114.bookstore.ui.bankscreen;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.model.api.UserBank;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.bankscreen.recycleViewBankSelector.OtherBankViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class SelectorBankPageViewModel extends BaseViewModel<SelectorBankPageNavigator> implements Observable {

    public final ObservableField<List<OtherBankViewModel>> listBanks = new ObservableField<>();

    @Inject
    protected ModelRemote remote;

    String userId;
    public void getData(UUID userId) {
        getCompositeDisposable().add(remote.getBanks(userId)
           .subscribeOn(getSchedulerProvider().io())
           .observeOn(getSchedulerProvider().ui())
           .subscribe(banks -> {
               List<OtherBankViewModel> list = new ArrayList<>();
               for (UserBank bank : banks) {
                   OtherBankViewModel model = new OtherBankViewModel();
                   model.setBank(bank, userId.toString());
                   list.add(model);
               }
               listBanks.set(list);
           }, throwable -> {
               Log.d("BankPageViewModel", "getData: " + throwable.getMessage(), throwable);
           }));
    }

    public SelectorBankPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
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
