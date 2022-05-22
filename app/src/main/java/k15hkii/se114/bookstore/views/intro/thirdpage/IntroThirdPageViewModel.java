package k15hkii.se114.bookstore.views.intro.thirdpage;

import androidx.databinding.Observable;
import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;

public class IntroThirdPageViewModel extends BaseViewModel<IntroThirdPageNavigator> implements Observable {

    public IntroThirdPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void openFinalPage(){
        getNavigator().openFinalPage();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
