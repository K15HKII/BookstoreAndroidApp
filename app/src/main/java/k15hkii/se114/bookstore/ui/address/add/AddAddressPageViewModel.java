package k15hkii.se114.bookstore.ui.address.add;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class AddAddressPageViewModel extends BaseViewModel<AddAddressPageNavigator> implements Observable {

    @Getter
    public final ObservableField<List<String>> lsCity = new ObservableField<>();

    @Getter
    public final ObservableField<List<String>> lsDistrict = new ObservableField<>(Arrays.asList("Quận 7", "Quận 2", "Quận 1"));

    @Getter
    public final ObservableField<List<String>> lsVillage = new ObservableField<>(Arrays.asList("Tân Kiểng", "Tân Phong", "Phường 7"));

    public final ObservableField<String> city = new ObservableField<>();
    public final ObservableField<String> district = new ObservableField<>();
    public final ObservableField<String> village = new ObservableField<>();
    public final ObservableField<String> addressNumber = new ObservableField<>();
    public final ObservableField<Boolean> defaultAddress = new ObservableField<>();

    public void Accept(){
        //TODO: save address
    }

    public AddAddressPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

}
