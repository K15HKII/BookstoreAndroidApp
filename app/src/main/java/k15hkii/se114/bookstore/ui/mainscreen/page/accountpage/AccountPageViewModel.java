package k15hkii.se114.bookstore.ui.mainscreen.page.accountpage;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.model.api.user.UserAddress;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.UUID;

public class AccountPageViewModel extends BaseViewModel<AccountPageNavigator> implements Observable {

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> gender = new ObservableField<>();
    public final ObservableField<String> birthday = new ObservableField<>();
    public final ObservableField<String> phone = new ObservableField<>();
    public final ObservableField<String> email = new ObservableField<>();
    public final ObservableField<UserAddress> address = new ObservableField<>();
    public final ObservableField<String> userName = new ObservableField<>();

    @Inject
    protected ModelRemote remote;
    private User user;
    private UUID userId;

    //TODO: getUser, UserBank, Sửa thông tin
    private String toUserName(User user){
        return user.getFirstName() + " " + user.getLastName();
    }

    private void getData(UUID userId) {
        getCompositeDisposable().add(remote.getSelfUser()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(user -> {
                    this.user = user;
                    this.userId = user.getId();
                    this.name.set(toUserName(user));
                    this.email.set(user.getEmail());
                    this.gender.set(String.valueOf(user.getGender()));
                    this.phone.set(user.getPhone());
                    this.birthday.set(String.valueOf(user.getBirthday()));
                    this.userName.set(String.valueOf(user.getUsername()));
                    this.notifyChange();
                }, throwable -> {
                    Log.d("AccInfoViewViewModel", "getSelfUser: " + throwable.getMessage(), throwable);
                }));

        // set address
        getCompositeDisposable().add(remote.getAddresses(userId)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(addresses -> {
                    for (UserAddress address : addresses)
                    {
                        if (address.isPrimary()){
                            this.address.set(address);
                        }
                    }
                }));
    }

    public AccountPageViewModel(SchedulerProvider schedulerProvider,ModelRemote remote, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.remote = remote;
        this.userId = preferencesHelper.getCurrentUserId();
        getData(userId);
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

    public void openOrderClick(){
        getNavigator().openOrder();
    }

    public void openRentClick(){
        getNavigator().openRent();
    }

    public void openFavoritePage(){
        getNavigator().openFavoritePage();
    }

    public void openRecentBook(){
        getNavigator().openRencentBook();
    }
}
