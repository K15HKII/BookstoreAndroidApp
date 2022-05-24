package k15hkii.se114.bookstore.views.bankscreen;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.orderitemsrecycleview.OrderView;

import java.util.Arrays;
import java.util.List;

public class SelectorBankPageViewModel extends BaseViewModel<SelectorBankPageNavigator> implements Observable {

    private final MutableLiveData<List<BankAccount>> selectorBankItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new BankAccount("Techcombank"),
                          new BankAccount("BIDV"))
    );

    public List<BankAccount> getSelectorBankItems() {
        return selectorBankItemsLiveData.getValue();
    }

    public SelectorBankPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    public void onOpenAddBankClick(){
        getNavigator().openAddBankAccount();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
