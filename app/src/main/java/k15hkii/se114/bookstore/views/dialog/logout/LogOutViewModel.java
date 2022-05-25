package k15hkii.se114.bookstore.views.dialog.logout;

import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;

public class LogOutViewModel extends BaseViewModel<LogOutCallBack> {
    public LogOutViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onCancleClick(){
        getNavigator().dismissDialog();
    }

    public void onAcceptClick(){
        getNavigator().openLoginScreen();
    }
}
