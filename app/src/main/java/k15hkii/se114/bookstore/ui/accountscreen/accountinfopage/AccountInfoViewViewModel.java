package k15hkii.se114.bookstore.ui.accountscreen.accountinfopage;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import k15hkii.se114.bookstore.data.model.api.User;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;

public class AccountInfoViewViewModel extends BaseViewModel<AccountInfoNavigator> implements Observable {

    @Inject
    protected ModelRemote remote;

    private User user;

    @Bindable
    public String getName() {
        return user.getFirstName() + " " + user.getLastName();
    }

    @Bindable
    public String getGender() {
        return user.getGender().name();
    }

    @Bindable
    public String getBirthday() {
        return user.getBirthday().toString();
    }

    @Bindable
    public String getPhone() {
        return user.getPhone();
    }

    @Bindable
    public String getEmail() {
        return user.getEmail();
    }

    public void setUserId(String id) {
        remote.getUser(id).doOnSuccess(user -> {
            this.user = user;
        }).subscribe();
    }

    public AccountInfoViewViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
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

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
