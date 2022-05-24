package k15hkii.se114.bookstore.views.dialog.changebirth;

import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;

public class ChangeBirthViewModel extends BaseViewModel<ChangeBirthCallBack> {
    public ChangeBirthViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onSubmitBirthText(){
        getNavigator().dismissDialog();
    }
}
