package k15hkii.se114.bookstore.ui.accountscreen.helppage.introduction;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

public class IntroductionViewModel extends BaseViewModel<IntroductionNavigator> implements Observable {
    public IntroductionViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
