package k15hkii.se114.bookstore.views.dialog.changepassword;

import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;

public class ChangePassDialogViewModel extends BaseViewModel<ChangePassCallBack> {
    public ChangePassDialogViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onSubmitPass(){
        getNavigator().onSubmitPass();
    }
}
