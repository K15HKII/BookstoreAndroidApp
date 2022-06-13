package k15hkii.se114.bookstore.ui.order;

import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class PaymentMethodViewModel extends BaseViewModel<PaymentMethodPageNavigator> {

    public PaymentMethodViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

    public void AcceptPayment() {
        //TODO: chọn phương thức thanh toán
    }

    public void openSelectBank() {
        //TODO: open Select Bank
        getNavigator().OpenSelectBank();
    }

}
