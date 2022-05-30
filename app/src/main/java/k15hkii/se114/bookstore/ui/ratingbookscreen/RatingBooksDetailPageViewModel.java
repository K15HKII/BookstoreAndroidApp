package k15hkii.se114.bookstore.ui.ratingbookscreen;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import java.util.Arrays;
import java.util.List;

public class RatingBooksDetailPageViewModel extends BaseViewModel<RatingBooksDetailPageNavigator> implements Observable {

    public final ObservableField<List<RatingReportViewModel>> listRate = new ObservableField<>(
            Arrays.asList(new RatingReportViewModel("Dac nhan tam"))
    );

    public RatingBooksDetailPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
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
