package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

//@AllArgsConstructor
@Getter
@Setter
public class RentViewViewModel extends BaseViewModel<RentViewNavigator> implements Observable {

    public final ObservableField<List<RentBookItemViewModel>> rentItems = new ObservableField<>(Arrays.asList());

    @Bindable
    @Setter @Getter private String price;
    @Setter @Getter private String note;
    @Setter @Getter private List<RentBookItemViewModel> rentListItem;

    @Inject protected ModelRemote remote;

    private String userId;
    private String rentBillId;

    public RentViewViewModel(String price, String note, List<RentBookItemViewModel> rentListItem) {
        super(null);
        this.price = price;
        this.note = note;
        rentItems.set(rentListItem);
    }

    public RentViewViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public RentViewViewModel() { super(null); }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    public void openDetail() {getNavigator().rentDetailNavigator(rentBillId); }
}
