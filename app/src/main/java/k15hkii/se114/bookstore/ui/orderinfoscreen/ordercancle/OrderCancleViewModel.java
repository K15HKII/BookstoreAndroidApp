package k15hkii.se114.bookstore.ui.orderinfoscreen.ordercancle;

import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.BaseOrderInfoViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class OrderCancleViewModel extends BaseOrderInfoViewModel<OrderCancleNavigator> {
    public OrderCancleViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, ModelRemote remote) {
        super(schedulerProvider, mapper, remote);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }
}
