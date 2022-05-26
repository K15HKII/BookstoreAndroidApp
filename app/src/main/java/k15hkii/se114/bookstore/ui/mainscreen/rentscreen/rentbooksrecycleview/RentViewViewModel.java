package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview;

import androidx.databinding.Observable;
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
    private final MutableLiveData<List<RentBookItemViewModel>> rentBookItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new RentBookItemViewModel("Dac nhan tam"),
                          new RentBookItemViewModel("huhu"))
    );

    @Setter @Getter private String price;
    @Setter @Getter private String note;
    @Setter @Getter private List<RentBookItemViewModel> rentListItem;

    @Inject protected ModelRemote remote;

    private String userId;
    private String rentBillId;

    // set data rent, waiting for rent

    public List<RentBookItemViewModel> getRentBookItems() {
        return rentBookItemsLiveData.getValue();
    }

    public RentViewViewModel(String price, String note, List<RentBookItemViewModel> rentListItem) {
        super(null);
        this.price = price;
        this.note = note;
        this.rentListItem = rentListItem;
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
