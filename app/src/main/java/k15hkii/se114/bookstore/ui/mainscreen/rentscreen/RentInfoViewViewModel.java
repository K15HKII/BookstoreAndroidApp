package k15hkii.se114.bookstore.ui.mainscreen.rentscreen;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class RentInfoViewViewModel extends BaseViewModel<RentInfoViewNavigator> implements Observable {

    public RentInfoViewViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper) {
        super(schedulerProvider);
        this.mapper = mapper;
    }
    @Inject
    protected ViewModelMapper mapper;
    private UUID billId;

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    public void openRentSuccess(){
        getNavigator().openRentSuccess();
    }

}
