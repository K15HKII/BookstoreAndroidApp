package k15hkii.se114.bookstore.ui.orderinfoscreen.orderrating;

import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.orderinfoscreen.BaseOrderInfoViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class OrderRatingViewModel extends BaseOrderInfoViewModel<OrderRatingNavigator> {

    public OrderRatingViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, ModelRemote remote) {
        super(schedulerProvider, mapper, remote);
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

    public void openRating() {
        getNavigator().openRating();
    }

}
