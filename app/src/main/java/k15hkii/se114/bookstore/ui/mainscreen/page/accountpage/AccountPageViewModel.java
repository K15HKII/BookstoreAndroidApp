package k15hkii.se114.bookstore.ui.mainscreen.page.accountpage;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.model.api.user.UserAddress;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.accountscreen.BaseUserInfoViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.UUID;

public class AccountPageViewModel extends BaseUserInfoViewModel<AccountPageNavigator> {

    public AccountPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, UUID userId) {
        super(schedulerProvider, remote, userId);
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

    public void openWaitingOrderClick(){
        getNavigator().openWaitingOrder();
    }

    public void openRentingClick(){
        getNavigator().openRenting();
    }

    public void openRentedClick(){
        getNavigator().openRented();
    }

    public void openFavoritePage(){
        getNavigator().openFavoritePage();
    }

    public void openRecentBook(){
        getNavigator().openRencentBook();
    }

    public void openShippingOrderClick(){
        getNavigator().openShippingOrder();
    }

    public void openArrivedOrderClick(){
        getNavigator().openArrivedOrder();
    }
}
