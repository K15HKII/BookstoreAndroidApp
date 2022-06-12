package k15hkii.se114.bookstore.ui.dialog.errornetwork;

import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class ErrorNetworkViewModel extends BaseViewModel<ErrorNetworkNavigator> {

    public ErrorNetworkViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void dismissDialog() {
        getNavigator().dismissDialog();
    }
}
