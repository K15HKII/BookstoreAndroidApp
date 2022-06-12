package k15hkii.se114.bookstore.ui.ratingbookscreen.ratelistbook;

import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class RateListBookViewModel extends BaseViewModel<RateListBookNavigator> {
    public RateListBookViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }
}
