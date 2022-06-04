package k15hkii.se114.bookstore.ui.mainscreen.page.accountpage;

import android.util.Log;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import k15hkii.se114.bookstore.data.model.api.User;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.UUID;

public class AccountPageViewModel extends BaseViewModel<AccountPageNavigator> implements Observable {

    private User user;
    private String email;
    private String name;
    private UUID userId;
    private String address;

    PreferencesHelper preferencesHelper;

    @Inject
    protected ModelRemote remote;

    void getData() {
//        getCompositeDisposable().add(remote.getUser(userId)
//                                           .subscribeOn(getSchedulerProvider().io())
//                                           .observeOn(getSchedulerProvider().ui())
//                                           .subscribe(user -> {
//                                               this.user = user;
//                                               this.notifyChange();
//                                           }, throwable -> {
//                                               Log.d("AccountPageViewModel", "getUser: " + throwable.getMessage(), throwable);
//                                           }));

        this.name = preferencesHelper.getCurrentUserName();
        this.email = preferencesHelper.getCurrentUserEmail();
    }

    @Bindable
    public String getName() {
        if (name == null) return "";
        return name;
    }

    @Bindable
    public String getEmail() {
        if (email == null) return "";
        return email;
    }

    public AccountPageViewModel(SchedulerProvider schedulerProvider, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.preferencesHelper = preferencesHelper;
//        this.userId = preferencesHelper.getCurrentUserId();
        getData();
    }

    public void onAccountInfoClick(){
        getNavigator().openAccountInfo();
    }

    public void onVoucherClick(){
        getNavigator().openVoucher();
    }

    public void onSettingClick(){
        getNavigator().openSetting();
    }

    public void onHelpCenterClick(){
        getNavigator().openHelpPage();
    }

    public void onLogOutClick(){
        getNavigator().logOut();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    // TODO: Implement the ViewModel
}
