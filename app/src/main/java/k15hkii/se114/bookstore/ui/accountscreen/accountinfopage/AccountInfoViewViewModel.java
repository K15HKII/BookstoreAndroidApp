package k15hkii.se114.bookstore.ui.accountscreen.accountinfopage;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.model.api.user.UserAddress;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.UUID;

public class AccountInfoViewViewModel extends BaseViewModel<AccountInfoNavigator> implements Observable {

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> gender = new ObservableField<>();
    public final ObservableField<String> birthday = new ObservableField<>();
    public final ObservableField<String> phone = new ObservableField<>();
    public final ObservableField<String> email = new ObservableField<>();
    public final ObservableField<String> address = new ObservableField<>();
    public final ObservableField<String> userName = new ObservableField<>();
    @Inject
    protected ModelRemote remote;
    private User user;
    private UUID user_id;

    private String toAddress(UserAddress address){
        return address.getNumber() + ", " + address.getStreet() + ", " + address.getCity() + ", " + address.getCountry();
    }
    //TODO: getUser
    private String toUserName(User user){
        return user.getFirstName() + " " + user.getLastName();
    }

    private void getData(UUID userId) {
        getCompositeDisposable().add(remote.getSelfUser()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(user -> {
                    this.user = user;
                    this.user_id= user.getId();
                    this.name.set(toUserName(user));
                    this.email.set(user.getEmail());
                    this.gender.set(String.valueOf(user.getGender()));
                    this.phone.set(user.getPhone());
                    this.birthday.set(String.valueOf(user.getBirthday()));
                    this.userName.set(String.valueOf(user.getUserName()));
                    this.notifyChange();
                }, throwable -> {
                    Log.d("AccInfoViewViewModel", "getSelfUser: " + throwable.getMessage(), throwable);
                }));

        // set address
        getCompositeDisposable().add(remote.getAddresses(user_id)
                                           .subscribeOn(getSchedulerProvider().io())
                                           .observeOn(getSchedulerProvider().ui())
                                           .subscribe(addresses -> {
                                               for (UserAddress address : addresses)
                                               {
                                                   if (address.is_primary()){
                                                       this.address.set(toAddress(address));
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
