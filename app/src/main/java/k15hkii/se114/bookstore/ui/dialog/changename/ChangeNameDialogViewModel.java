package k15hkii.se114.bookstore.ui.dialog.changename;

import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

public class ChangeNameDialogViewModel extends BaseViewModel<ChangeNameCallBack> {
    public ChangeNameDialogViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onSubmitClick(){
        getNavigator().dismissDialog();
    }
}
