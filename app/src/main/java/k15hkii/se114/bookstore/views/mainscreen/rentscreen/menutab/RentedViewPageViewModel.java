package k15hkii.se114.bookstore.views.mainscreen.rentscreen.menutab;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;
import k15hkii.se114.bookstore.views.mainscreen.rentscreen.rentbooksrecycleview.RentBookItem;
import k15hkii.se114.bookstore.views.mainscreen.rentscreen.rentbooksrecycleview.RentView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RentedViewPageViewModel extends BaseViewModel<RentedViewPageNavigator> implements Observable {

    private final MutableLiveData<List<RentView>> rentedViewItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new RentView("240.000", "note", getRentedListItem(2)),
                          new RentView("120.000", "note", getRentedListItem(1)))
    );

    public List<RentBookItem> getRentedListItem(int quantity) {

        List<RentBookItem> listItem = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            listItem.add(new RentBookItem("Dac nhan tam"));
        }

        return listItem;
    }

    public List<RentView> getRentedBookItems() {
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
