package k15hkii.se114.bookstore.ui.accountscreen.helppage.policy;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

public class PolicyViewModel extends BaseViewModel<PolicyNavigator> implements Observable {
    public PolicyViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

}
