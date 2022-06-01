package k15hkii.se114.bookstore.ui.mainscreen.page.accountpage;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.data.model.api.User;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;

public class AccountPageViewModel extends BaseViewModel<AccountPageNavigator> implements Observable {

    private String userId;
    private User user;

    @Inject
    protected ModelRemote remote;

    public AccountPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void setUserId(String id) {
        remote.getUser(id).doOnSuccess(user ->  {
            userId = String.valueOf(user.getId());
        }).subscribe();
    }

    public AccountPageViewModel(SchedulerProvider schedulerProvider, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
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
