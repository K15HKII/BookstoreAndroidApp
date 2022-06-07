package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.add;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

public class AddRentBookViewViewModel extends BaseViewModel<AddRentBookViewNavigator> implements Observable {
    public AddRentBookViewViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public final ObservableField<String> bookName = new ObservableField<>();
    public final ObservableField<String> bookType = new ObservableField<>();
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

    public void openRentBookDetail(){
        getNavigator().openRentBookDetail();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
