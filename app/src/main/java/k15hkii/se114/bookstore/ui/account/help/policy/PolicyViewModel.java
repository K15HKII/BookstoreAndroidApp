package k15hkii.se114.bookstore.ui.account.help.policy;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class PolicyViewModel extends BaseViewModel<PolicyNavigator> implements Observable {

    public PolicyViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

}
