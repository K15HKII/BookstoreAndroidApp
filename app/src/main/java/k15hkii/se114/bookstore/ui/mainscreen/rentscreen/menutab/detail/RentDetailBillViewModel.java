package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab.detail;

import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class RentDetailBillViewModel extends BaseViewModel<RentDetailBillNavigator> {
    public RentDetailBillViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }
}
