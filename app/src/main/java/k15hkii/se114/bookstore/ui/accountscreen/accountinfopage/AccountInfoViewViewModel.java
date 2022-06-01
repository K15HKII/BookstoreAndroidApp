package k15hkii.se114.bookstore.ui.accountscreen.accountinfopage;

import android.util.Log;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.data.model.api.User;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;

public class AccountInfoViewViewModel extends BaseViewModel<AccountInfoNavigator> implements Observable {

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

    private void getUser() {
        getCompositeDisposable().add(remote.getSelfUser()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(user -> {
                    this.user = user;
                    this.notifyChange();
                }, throwable -> {
                    Log.d("AccInfoViewViewModel", "getUser: " + throwable.getMessage(), throwable);
                }));
    }

    public AccountInfoViewViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
        getUser();
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
