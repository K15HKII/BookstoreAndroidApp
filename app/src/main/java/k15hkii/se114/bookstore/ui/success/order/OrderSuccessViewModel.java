package k15hkii.se114.bookstore.ui.success.order;

import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class OrderSuccessViewModel extends BaseViewModel<OrderSuccessNavigator> {
    public OrderSuccessViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackHomeClick(){
        getNavigator().BackHome();
    }
}
