package k15hkii.se114.bookstore.ui.mainscreen.rentscreen;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.UUID;

public class RentInfoViewViewModel extends BaseViewModel<RentInfoViewNavigator> implements Observable {

    public RentInfoViewViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper) {
        super(schedulerProvider);
        this.mapper = mapper;
    }

    @Inject
    protected ViewModelMapper mapper;
    private UUID billId;

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

    public void openRentSuccess() {
        getNavigator().openRentSuccess();
    }

}
