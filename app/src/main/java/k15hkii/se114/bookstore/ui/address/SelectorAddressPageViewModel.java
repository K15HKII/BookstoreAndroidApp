package k15hkii.se114.bookstore.ui.address;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import java.util.Arrays;
import java.util.List;

public class SelectorAddressPageViewModel extends BaseViewModel<SelectorAddressPageNavigator> implements Observable {

    private final MutableLiveData<List<Address>> selectorAddressItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new Address("Biên Hòa, Đồng Nai"),
                          new Address("Khánh Hòa"))
    );

    public List<Address> getAddressItems() {
        return selectorAddressItemsLiveData.getValue();
    }

    public SelectorAddressPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    public void onOpenAddBankClick(){
        getNavigator().openAddBank();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
