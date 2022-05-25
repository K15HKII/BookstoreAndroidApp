package k15hkii.se114.bookstore.ui.dialog.buynow;

import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

public class BuyNowViewModel extends BaseViewModel<BuyNowCallBack> {
    public BuyNowViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void dismissDialog(){
        getNavigator().dismissDialog();
    }
}
