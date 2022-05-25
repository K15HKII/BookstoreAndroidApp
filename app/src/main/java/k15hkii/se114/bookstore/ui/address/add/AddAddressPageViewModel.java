package k15hkii.se114.bookstore.ui.address.add;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class AddAddressPageViewModel extends BaseViewModel<AddAddressPageNavigator> implements Observable {

    @Getter
    private final MutableLiveData<List<String>> lsCity = new MutableLiveData<>(Arrays.asList("Hồ Chí Minh", "Hà Nội", "Hải Phòng"));

    @Getter
    private final MutableLiveData<List<String>> lsDistrict = new MutableLiveData<>(Arrays.asList("Quận 7", "Quận 2", "Quận 1"));

    @Getter
    private final MutableLiveData<List<String>> lsVillage = new MutableLiveData<>(Arrays.asList("Tân Kiểng", "Tân Phong", "Phường 7"));

    public AddAddressPageViewModel(SchedulerProvider schedulerProvider) {
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
