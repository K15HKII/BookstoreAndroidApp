package k15hkii.se114.bookstore.ui.accountscreen.helppage;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

public class HelpPageViewModel extends BaseViewModel<HelpPageNavigator> implements Observable {
    public HelpPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    public void onHelpCenterClick(){
        getNavigator().openHelpCenter();
    }

    public void onIntroductionAppClick(){
        getNavigator().openAppIntroduction();
    }

    public void onPolicyClick(){
        getNavigator().openPolicy();
    }

    public void onDeleteAccountRequest(){
        getNavigator().openDeleteAccountRequest();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
