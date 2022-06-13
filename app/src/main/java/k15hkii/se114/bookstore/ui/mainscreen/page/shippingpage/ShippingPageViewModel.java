package k15hkii.se114.bookstore.ui.mainscreen.page.shippingpage;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class ShippingPageViewModel extends BaseViewModel<ShippingPageNavigator> implements Observable {

    public ShippingPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

}
