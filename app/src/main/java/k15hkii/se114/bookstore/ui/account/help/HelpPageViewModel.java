package k15hkii.se114.bookstore.ui.account.help;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class HelpPageViewModel extends BaseViewModel<HelpPageNavigator> implements Observable {

    public HelpPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

    public void onHelpCenterClick() {
        getNavigator().openHelpCenter();
    }

    public void onIntroductionAppClick() {
        getNavigator().openAppIntroduction();
    }

    public void onPolicyClick() {
        getNavigator().openPolicy();
    }

    public void onDeleteAccountRequest() {
        getNavigator().openDeleteAccountRequest();
    }

}
