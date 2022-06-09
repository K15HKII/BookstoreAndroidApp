package k15hkii.se114.bookstore.ui.dialog.buynow;

import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

public class BuyNowViewModel extends BaseViewModel<BuyNowCallBack> {

    public final ObservableField<String> amount = new ObservableField<>();

    public BuyNowViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void dismissDialog(){
        getNavigator().dismissDialog();
        getNavigator().openCartPage();
    }

}
