package k15hkii.se114.bookstore.ui.dialog.emptycart;

import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class EmptyCartViewModel extends BaseViewModel<EmptyCartNavigator> {

    public EmptyCartViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void dismissDialog() {
        getNavigator().dismissDialog();
    }

}
