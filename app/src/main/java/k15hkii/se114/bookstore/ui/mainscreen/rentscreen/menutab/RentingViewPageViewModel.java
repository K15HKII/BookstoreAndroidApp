package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentBookItem;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RentingViewPageViewModel extends BaseViewModel<RentingViewPageNavigator> implements Observable {

    private final MutableLiveData<List<RentView>> rentingViewItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new RentView("240.000", "note", getRentingListItem(2)),
                          new RentView("120.000", "note", getRentingListItem(1)))
    );

    public List<RentBookItem> getRentingListItem(int quantity) {

        List<RentBookItem> listItem = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            listItem.add(new RentBookItem("Dac nhan tam"));
        }

        return listItem;
    }

    public List<RentView> getRentingBookItems() {
        return rentingViewItemsLiveData.getValue();
    }

    public RentingViewPageViewModel(SchedulerProvider schedulerProvider) {
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
