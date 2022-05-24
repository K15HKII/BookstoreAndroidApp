package k15hkii.se114.bookstore.views.dialog.oncart;

import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;

public class OnCartViewModel extends BaseViewModel<OnCartCallBack> {
    public OnCartViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void dismissDialog(){
        getNavigator().dismissDialog();
    }
}
