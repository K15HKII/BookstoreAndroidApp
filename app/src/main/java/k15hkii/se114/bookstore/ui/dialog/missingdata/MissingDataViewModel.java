package k15hkii.se114.bookstore.ui.dialog.missingdata;

import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class MissingDataViewModel extends BaseViewModel<MissingDataNavigator> {

    public MissingDataViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void dismissDialog() {
        getNavigator().dismissDialog();
    }

}
