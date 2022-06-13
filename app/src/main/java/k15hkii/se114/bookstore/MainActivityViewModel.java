package k15hkii.se114.bookstore;

import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class MainActivityViewModel extends BaseViewModel<MainActivityNavigator> {

    public MainActivityViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

}
