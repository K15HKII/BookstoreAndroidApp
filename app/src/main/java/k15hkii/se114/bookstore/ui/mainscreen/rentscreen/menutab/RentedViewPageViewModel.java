package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentViewViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

public class RentedViewPageViewModel extends BaseViewModel<RentedViewPageNavigator> implements Observable {

    public final ObservableField<List<RentViewViewModel>> rentedlist = new ObservableField<>();

    @Inject
    protected ViewModelMapper remote;

    private final UUID userId;

    public void getData() {
        dispose(remote.getLends(userId),
                rentedlist::set,
                throwable -> Log.d("RentedPageViewModel", "getData: " + throwable.getMessage(), throwable));
    }

    public RentedViewPageViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.remote = mapper;
        this.userId = preferencesHelper.getCurrentUserId();
        getData();
    }

}
