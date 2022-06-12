package k15hkii.se114.bookstore.ui.accountscreen.accountinfopage;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.model.api.user.UserAddress;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.accountscreen.BaseUserInfoViewModel;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.UUID;

public class AccountInfoViewViewModel extends BaseUserInfoViewModel<AccountInfoNavigator> implements Observable {

    public AccountInfoViewViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, UUID userId) {
        super(schedulerProvider, remote, userId);
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
