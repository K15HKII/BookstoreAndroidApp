package k15hkii.se114.bookstore.ui.intro.fourthpage;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class IntroFourthPageViewModel extends BaseViewModel<IntroFourthPageNavigator> implements Observable {

    public IntroFourthPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void openLoginClick() {
        getNavigator().openLogin();
    }

}
