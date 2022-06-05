package k15hkii.se114.bookstore.ui.ratingbookscreen;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.data.model.api.Bill;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.bankscreen.BankExpandableListView.BankItems;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import lombok.Getter;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class RatingBooksDetailPageViewModel extends BaseViewModel<RatingBooksDetailPageNavigator> implements Observable {

    public final ObservableField<List<RatingReportViewModel>> listRate = new ObservableField<>();

    @Inject
    protected ModelRemote remote;
    private UUID userId;
    public void getData(UUID userId) {
        getCompositeDisposable().add(remote.getBills(userId)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(bills -> {
                    List<RatingReportViewModel> list = new ArrayList<>();
                    for (Bill bill : bills) {
                        RatingReportViewModel model = new RatingReportViewModel();
                        model.setRate(bill);
                        list.add(model);
                    }
                    listRate.set(list);
                }, throwable -> {
                    Log.d("RatingViewModel", "getData: " + throwable.getMessage(), throwable);
                }));
    }

    public RatingBooksDetailPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.remote = remote;
        this.userId = preferencesHelper.getCurrentUserId();
        getData(userId);
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
