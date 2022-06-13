package k15hkii.se114.bookstore.ui.account.help.introduction;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class IntroductionViewModel extends BaseViewModel<IntroductionNavigator> implements Observable {

    public IntroductionViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

}
