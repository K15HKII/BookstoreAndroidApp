package k15hkii.se114.bookstore.ui.mainscreen.rentscreen;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RentInfoViewViewModel extends BaseViewModel<RentInfoViewNavigator> implements Observable {


    ModelRemote remote;
    public RentInfoViewViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    public void openRentSuccess(){
        getNavigator().openRentSuccess();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
