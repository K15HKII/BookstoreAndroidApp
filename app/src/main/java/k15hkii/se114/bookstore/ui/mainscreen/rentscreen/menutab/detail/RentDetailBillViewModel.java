package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab.detail;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class RentDetailBillViewModel extends BaseViewModel<RentDetailBillNavigator> {
    public RentDetailBillViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public final ObservableField<String> bookName = new ObservableField<>(); //title
    public final ObservableField<String> bookType = new ObservableField<>(); //description
    public final ObservableField<String> bookImage = new ObservableField<>();
    public final ObservableField<String> bookRentPrice = new ObservableField<>();
    public final ObservableField<String> expiredDate = new ObservableField<>();
    public final ObservableField<String> voucherInfo = new ObservableField<>();
    public final ObservableField<String> paymentMethod = new ObservableField<>();
    public final ObservableField<String> rentPrice = new ObservableField<>();
    public final ObservableField<String> discount = new ObservableField<>();
    public final ObservableField<String> totalPrice = new ObservableField<>();

    public void onBackWardClick(){
        getNavigator().BackWard();
    }
}
