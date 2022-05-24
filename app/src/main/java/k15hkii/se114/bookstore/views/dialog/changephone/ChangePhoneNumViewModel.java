package k15hkii.se114.bookstore.views.dialog.changephone;

import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;

public class ChangePhoneNumViewModel extends BaseViewModel<ChangePhoneNumCallBack> {
    public ChangePhoneNumViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onSubmitPhoneTextClick(){
        getNavigator().onSubmitPhone();
    }
}
