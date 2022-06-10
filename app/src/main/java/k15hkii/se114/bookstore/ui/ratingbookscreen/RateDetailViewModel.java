package k15hkii.se114.bookstore.ui.ratingbookscreen;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

public class RateDetailViewModel extends BaseViewModel<RatingBooksDetailPageNavigator> implements Observable {

    @Inject
    protected ViewModelMapper mapper;
    private final UUID userId;
//    public void getData() {
//        dispose(mapper.getRatings(userId),
//                listRate::set,
//                throwable -> Log.d("RateDetailViewModel", "getData: " + throwable.getMessage(), throwable));
//    }

    public RateDetailViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.mapper = mapper;
        this.userId = preferencesHelper.getCurrentUserId();
//        getData();
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    public void ConfirmRating(){
        //TODO: Confirm Rating
    }

}
