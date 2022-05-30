package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentViewViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentBookItemViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RentingViewPageViewModel extends BaseViewModel<RentingViewPageNavigator> implements Observable {

    public final ObservableField<List<RentViewViewModel>> rentList = new ObservableField<>(
            Arrays.asList(new RentViewViewModel("240.000", "note", getRentingListItem(2)),
                          new RentViewViewModel("120.000", "note", getRentingListItem(1)))
    );

    public List<RentBookItemViewModel> getRentingListItem(int quantity) {

        List<RentBookItemViewModel> listItem = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            listItem.add(new RentBookItemViewModel("Dac nhan tam"));
        }
        return listItem;
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
}
