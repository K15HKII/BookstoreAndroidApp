package k15hkii.se114.bookstore.ui.dialog.changephone;

import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

public class ChangePhoneNumViewModel extends BaseViewModel<ChangePhoneNumCallBack> {
    public ChangePhoneNumViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onSubmitPhoneTextClick(){
        getNavigator().onSubmitPhone();
    }
}
