package k15hkii.se114.bookstore.views.dialog.changename;

import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;

public class ChangeNameDialogViewModel extends BaseViewModel<ChangeNameCallBack> {
    public ChangeNameDialogViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onSubmitClick(){
        getNavigator().dismissDialog();
    }
}
