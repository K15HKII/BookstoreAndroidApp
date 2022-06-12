package k15hkii.se114.bookstore.ui.address.edit;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.remote.LocationRepository;
import k15hkii.se114.bookstore.ui.address.BaseAddressUpdateViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class EditAddressPageViewModel extends BaseAddressUpdateViewModel<EditAddressPageNavigator> implements Observable {

    public final ObservableField<String> addressNumber = new ObservableField<>();
    public final ObservableField<Boolean> defaultAddress = new ObservableField<>();

    public void Accept(){
        //TODO: save address
    }

    public EditAddressPageViewModel(SchedulerProvider schedulerProvider, LocationRepository locationRepository) {
        super(schedulerProvider, locationRepository);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

}
