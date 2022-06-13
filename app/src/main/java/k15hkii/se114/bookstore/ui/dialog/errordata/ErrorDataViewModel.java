package k15hkii.se114.bookstore.ui.dialog.errordata;

import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class ErrorDataViewModel extends BaseViewModel<ErrorDataNavigator> {

    public ErrorDataViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void dismissDialog() {
        getNavigator().dismissDialog();
    }

}
