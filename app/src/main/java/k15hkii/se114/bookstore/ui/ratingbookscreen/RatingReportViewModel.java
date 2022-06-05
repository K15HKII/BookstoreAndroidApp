package k15hkii.se114.bookstore.ui.ratingbookscreen;

import androidx.databinding.Bindable;
import k15hkii.se114.bookstore.data.model.api.Bill;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Getter;
import lombok.Setter;

import java.security.SecureRandom;
import java.util.UUID;

public class RatingReportViewModel extends BaseViewModel<IRatingReportNavigator> {

    @Bindable
    @Getter @Setter
    private String RateBook;
    private Bill bill;
    public void setRate(Bill bill){
        this.bill = bill;
    }
    public RatingReportViewModel(){
        super(null);
    }
    public RatingReportViewModel(String rateBook) {
        super(null);
        RateBook = rateBook;
    }

    public RatingReportViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }
}
