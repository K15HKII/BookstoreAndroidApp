package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentViewViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentBookItemViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RentedViewPageViewModel extends BaseViewModel<RentedViewPageNavigator> implements Observable {

    private final MutableLiveData<List<RentViewViewModel>> rentedViewItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new RentViewViewModel("240.000", "note", getRentedListItem(2)),
                          new RentViewViewModel("120.000", "note", getRentedListItem(1)))
    );

    public List<RentBookItemViewModel> getRentedListItem(int quantity) {

        List<RentBookItemViewModel> listItem = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            listItem.add(new RentBookItemViewModel("Dac nhan tam"));
        }

        return listItem;
    }

    public List<RentViewViewModel> getRentedBookItems() {
        return rentedViewItemsLiveData.getValue();
    }

    public RentedViewPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
