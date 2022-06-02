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

public class RentedViewPageViewModel extends BaseViewModel<RentedViewPageNavigator> implements Observable {

    public final ObservableField<List<RentViewViewModel>> rentedlist = new ObservableField<>();

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
