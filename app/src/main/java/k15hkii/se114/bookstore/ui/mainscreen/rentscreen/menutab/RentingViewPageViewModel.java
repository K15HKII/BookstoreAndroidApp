package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.model.api.Lend;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentViewViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RentingViewPageViewModel extends BaseViewModel<RentingViewPageNavigator> implements Observable {

    public final ObservableField<List<RentViewViewModel>> rentList = new ObservableField<>();

    @Inject protected ModelRemote remote;
    private UUID userId;
    public void getData() {
        getCompositeDisposable().add(remote.getLends(userId)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(lends -> {
                    List<RentViewViewModel> list = new ArrayList<>();
                    for (Lend lend : lends) {
                        RentViewViewModel model = new RentViewViewModel();
                        model.setLend(lend);
                        list.add(model);
                    }
                    rentList.set(list);
                }, throwable -> {
                    Log.d("RentingPageViewModel", "getData: " + throwable.getMessage(), throwable);
                }));
    }

    public RentingViewPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.remote = remote;
        this.userId = preferencesHelper.getCurrentUserId();
        getData();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
}
