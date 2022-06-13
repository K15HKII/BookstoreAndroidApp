package k15hkii.se114.bookstore.ui.intro.firstpage;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class IntroFirstPageViewModel extends BaseViewModel<IntroFirstPageNavigator> implements Observable {

    public IntroFirstPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void openNextPageClick() {
        getNavigator().openNextPage();
    }

}
