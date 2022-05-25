package k15hkii.se114.bookstore.ui.accountscreen.helppage.helpcenter;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

public class HelpCenterViewModel extends BaseViewModel<HelpCenterNavigator> implements Observable {
    public HelpCenterViewModel(SchedulerProvider schedulerProvider) {
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
