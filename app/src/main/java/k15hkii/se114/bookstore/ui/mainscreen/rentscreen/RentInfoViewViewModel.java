package k15hkii.se114.bookstore.ui.mainscreen.rentscreen;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RentInfoViewViewModel extends BaseViewModel<RentInfoViewNavigator> implements Observable {

    ModelRemote remote;
    public RentInfoViewViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
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

    public void openRentSuccess(){
        getNavigator().openRentSuccess();
    }

}
