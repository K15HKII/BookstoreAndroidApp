package k15hkii.se114.bookstore.ui.dialog.failedcheck;

import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class FailedCheckViewModel extends BaseViewModel<FailedCheckCallBack> {

    public FailedCheckViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void dismissDialog() {
        getNavigator().dismissDialog();
    }

}
