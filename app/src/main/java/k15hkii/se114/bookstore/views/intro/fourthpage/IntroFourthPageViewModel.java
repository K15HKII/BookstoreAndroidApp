package k15hkii.se114.bookstore.views.intro.fourthpage;

import androidx.databinding.Observable;
import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;

public class IntroFourthPageViewModel extends BaseViewModel<IntroFourthPageNavigator> implements Observable {
    public IntroFourthPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void openLoginClick(){
        getNavigator().openLogin();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
