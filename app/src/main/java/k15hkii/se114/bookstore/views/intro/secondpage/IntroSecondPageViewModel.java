package k15hkii.se114.bookstore.views.intro.secondpage;

import androidx.databinding.Observable;
import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;

public class IntroSecondPageViewModel extends BaseViewModel<IntroSecondPageNavigator> implements Observable {
    public IntroSecondPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void openNextPageClick(){
        getNavigator().openNextPage();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
