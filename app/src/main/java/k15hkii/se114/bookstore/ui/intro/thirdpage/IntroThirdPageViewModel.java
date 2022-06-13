package k15hkii.se114.bookstore.ui.intro.thirdpage;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class IntroThirdPageViewModel extends BaseViewModel<IntroThirdPageNavigator> implements Observable {

    public IntroThirdPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void openFinalPage() {
        getNavigator().openFinalPage();
    }

}
