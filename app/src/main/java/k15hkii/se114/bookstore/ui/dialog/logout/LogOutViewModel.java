package k15hkii.se114.bookstore.ui.dialog.logout;

import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class LogOutViewModel extends BaseViewModel<LogOutCallBack> {

    public LogOutViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onCancleClick() {
        getNavigator().dismissDialog();
    }

    public void onAcceptClick() {
        getNavigator().openLoginScreen();
    }

}
