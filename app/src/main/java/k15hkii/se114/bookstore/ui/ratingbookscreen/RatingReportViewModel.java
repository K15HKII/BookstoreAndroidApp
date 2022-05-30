package k15hkii.se114.bookstore.ui.ratingbookscreen;

import androidx.databinding.Bindable;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Getter;
import lombok.Setter;

public class RatingReportViewModel extends BaseViewModel<IRatingReportNavigator> {

    @Bindable
    @Getter @Setter
    private String RateBook;

    public RatingReportViewModel(String rateBook) {
        super(null);
        RateBook = rateBook;
    }

    public RatingReportViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }
}
