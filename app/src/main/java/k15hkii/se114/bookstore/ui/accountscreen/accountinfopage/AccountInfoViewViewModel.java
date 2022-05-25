package k15hkii.se114.bookstore.ui.accountscreen.accountinfopage;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

public class AccountInfoViewViewModel extends BaseViewModel<AccountInfoNavigator> implements Observable {
    public AccountInfoViewViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    public void openChangeNameDialog(){
        getNavigator().openChangeNameDialog();
    }

    public void openChangePasswordDialog(){
        getNavigator().openChangePasswordDialog();
    }

    public void openChangePhoneNumberDialog(){
        getNavigator().openChangePhoneNumDialog();
    }

    public void openChangeGenderDialog(){
        getNavigator().openChangeGenderDialog();
    }

    public void openChangeBirthDialog(){
        getNavigator().openChangeBirthDialog();
    }

    public void openSelectorAddressClick(){
        getNavigator().openSelectAddress();
    }

    public void openSelectorBankClick(){
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
