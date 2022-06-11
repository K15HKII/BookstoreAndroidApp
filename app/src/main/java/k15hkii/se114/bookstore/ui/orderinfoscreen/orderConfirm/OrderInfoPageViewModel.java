package k15hkii.se114.bookstore.ui.orderinfoscreen.orderConfirm;

import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.orderinfoscreen.BaseOrderViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class OrderInfoPageViewModel extends BaseOrderViewModel<OrderInfoPageNavigator> {

    public OrderInfoPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, ViewModelMapper mapper) {
        super(schedulerProvider, mapper, remote);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    public void openSuccessOrder(){
        getNavigator().SucceedOrder();
    }

}
