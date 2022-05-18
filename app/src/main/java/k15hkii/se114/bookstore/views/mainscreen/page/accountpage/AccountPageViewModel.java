package k15hkii.se114.bookstore.views.mainscreen.page.accountpage;

import androidx.databinding.Observable;
import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;

public class AccountPageViewModel extends BaseViewModel<AccountPageNavigator> implements Observable {
    public AccountPageViewModel(SchedulerProvider schedulerProvider) {
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
