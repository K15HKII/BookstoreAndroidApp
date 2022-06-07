package k15hkii.se114.bookstore.ui.accountscreen.accountinfopage;

import android.util.Log;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.model.api.user.UserAddress;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.UUID;

public class AccountInfoViewViewModel extends BaseViewModel<AccountInfoNavigator> implements Observable {

    @Inject
    protected ModelRemote remote;

    private User user;
    private UUID user_id;
    private String address;
    @Bindable
    public String getName() {
        if (user == null) return "";
        return user.getFirstName() + " " + user.getLastName();
    }

    @Bindable
    public String getGender() {
        if (user == null) return "";
        if (user.getGender() == null) return "";
        return user.getGender().name();
    }

    @Bindable
    public String getBirthday() {
        if (user == null) return "";
        if (user.getBirthday() == null) return "";
        return user.getBirthday().toString();
    }

    @Bindable
    public String getPhone() {
        if (user == null) return "";
        return user.getPhone();
    }

    @Bindable
    public String getEmail() {
        if (user == null) return "";
        return user.getEmail();
    }

    @Bindable
    public String getAddress() {
        if (address == null) return "null";
        return address;
    }

    private void getData(UUID userId) {
        getCompositeDisposable().add(remote.getSelfUser()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(user -> {
                    this.user = user;
                    this.notifyChange();
                }, throwable -> {
                    Log.d("AccInfoViewViewModel", "getUser: " + throwable.getMessage(), throwable);
                }));

        // set address
        getCompositeDisposable().add(remote.getAddresses(userId)
                                           .subscribeOn(getSchedulerProvider().io())
                                           .observeOn(getSchedulerProvider().ui())
                                           .subscribe(addresses -> {
                                               for (UserAddress address : addresses)
                                               {
                                                   if (address.is_primary()){
                                                       this.address = address.getCity();
                                                   }
                                               }
                                           }));
    }
    public AccountInfoViewViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.remote = remote;
        this.user_id = preferencesHelper.getCurrentUserId();
        getData(user_id);
    }

    public void onBackWardClick() {
        getNavigator().backward();
    }

    public void openChangeNameDialog() {
        getNavigator().openChangeNameDialog();
    }

    public void openChangePasswordDialog() {
        getNavigator().openChangePasswordDialog();
    }

    public void openChangePhoneNumberDialog() {
        getNavigator().openChangePhoneNumDialog();
    }

    public void openChangeGenderDialog() {
        getNavigator().openChangeGenderDialog();
    }

    public void openChangeBirthDialog() {
        getNavigator().openChangeBirthDialog();
    }

    public void openSelectorAddressClick() {
        getNavigator().openSelectAddress();
    }

    public void openSelectorBankClick() {
        getNavigator().openSelectBank();
    }
}
