package k15hkii.se114.bookstore.ui.mainscreen.rentscreen;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentViewViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentBookItemViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RentInfoViewViewModel extends BaseViewModel<RentInfoViewNavigator> implements Observable {

    private final MutableLiveData<List<RentViewViewModel>> rentInfoViewItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new RentViewViewModel("20.000", "note", getRentListItem(2)))
    );

    public List<RentBookItemViewModel> getRentListItem(int quantity) {

        List<RentBookItemViewModel> rentListItem = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {

            rentListItem.add(new RentBookItemViewModel("Dac nhan tam"));
        }

        return rentListItem;
    }
    public List<RentViewViewModel> getRentInfoViewItems() {
        return rentInfoViewItemsLiveData.getValue();
    }

    public RentInfoViewViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
