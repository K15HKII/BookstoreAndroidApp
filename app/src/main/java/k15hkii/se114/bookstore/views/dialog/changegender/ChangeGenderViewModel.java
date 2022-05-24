package k15hkii.se114.bookstore.views.dialog.changegender;

import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;

public class ChangeGenderViewModel extends BaseViewModel<ChangeGenderDialogCallBack> {
    public ChangeGenderViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onSubmitGenderText(){
        getNavigator().onSubmitGender();
    }
}
