package k15hkii.se114.bookstore.ui.mainscreen.page.accountpage;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

public class AccountPageViewModel extends BaseViewModel<AccountPageNavigator> implements Observable {

    private String userId;



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
