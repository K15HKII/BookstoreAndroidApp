package k15hkii.se114.bookstore.ui.order.checker;

import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.order.BaseOrderInfoViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class OrderCheckerViewModel extends BaseOrderInfoViewModel<OrderCheckerNavigator> {

    public OrderCheckerViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, ModelRemote remote) {
        super(schedulerProvider, mapper, remote);
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

}
