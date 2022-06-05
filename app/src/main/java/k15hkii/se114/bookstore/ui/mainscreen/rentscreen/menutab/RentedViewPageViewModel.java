package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.Lend;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelRemote;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentViewViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RentedViewPageViewModel extends BaseViewModel<RentedViewPageNavigator> implements Observable {

    public final ObservableField<List<RentViewViewModel>> rentedlist = new ObservableField<>();

    @Inject
    protected ViewModelRemote remote;

    private final UUID userId;

    public void getData() {
        dispose(remote.getLends(userId),
                rentedlist::set,
                throwable -> Log.d("RentedPageViewModel", "getData: " + throwable.getMessage(), throwable));
    }
    public RentedViewPageViewModel(SchedulerProvider schedulerProvider, ViewModelRemote modelRemote, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.remote=modelRemote;
        this.userId = preferencesHelper.getCurrentUserId();
        getData();
    }

}
