package k15hkii.se114.bookstore.ui.success.lend;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class LendSuccessViewModel extends BaseViewModel<LendSuccessNavigator> implements Observable {

    public LendSuccessViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackHomeClick() {
        getNavigator().BackHome();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

}
