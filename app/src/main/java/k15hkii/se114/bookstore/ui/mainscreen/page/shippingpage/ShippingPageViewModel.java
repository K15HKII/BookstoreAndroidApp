package k15hkii.se114.bookstore.ui.mainscreen.page.shippingpage;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

public class ShippingPageViewModel extends BaseViewModel<ShippingPageNavigator> implements Observable {
    public ShippingPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

}
