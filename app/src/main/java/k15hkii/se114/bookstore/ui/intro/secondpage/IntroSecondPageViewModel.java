package k15hkii.se114.bookstore.ui.intro.secondpage;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class IntroSecondPageViewModel extends BaseViewModel<IntroSecondPageNavigator> implements Observable {

    public IntroSecondPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void openNextPageClick() {
        getNavigator().openNextPage();
    }

}
