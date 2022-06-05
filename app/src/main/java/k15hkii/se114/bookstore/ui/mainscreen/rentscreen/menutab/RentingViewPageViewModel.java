package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentViewViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import java.util.List;
import java.util.UUID;

public class RentingViewPageViewModel extends BaseViewModel<RentingViewPageNavigator> implements Observable {

    public final ObservableField<List<RentViewViewModel>> rentList = new ObservableField<>();

    protected ViewModelMapper mapper;
    private final UUID userId;

    public void getData() {
        dispose(mapper.getLends(userId),
                rentList::set,
                throwable -> Log.d("RentingPageViewModel", "getData: " + throwable.getMessage(), throwable));
    }

    public RentingViewPageViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.mapper = mapper;
        this.userId = preferencesHelper.getCurrentUserId();
        getData();
    }

}
