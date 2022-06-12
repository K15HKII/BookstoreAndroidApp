package k15hkii.se114.bookstore.ui.mainscreen.page.rentpage;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

public class RentPageViewModel extends BaseViewModel<RentPageNavigator> implements Observable {
    public RentPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onAddRentBillClick(){
        getNavigator().openAddRentBill();
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }
}
