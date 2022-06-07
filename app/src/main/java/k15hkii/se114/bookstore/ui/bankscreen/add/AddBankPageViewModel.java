package k15hkii.se114.bookstore.ui.bankscreen.add;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class AddBankPageViewModel extends BaseViewModel<AddBankPageNavigator> implements Observable {
    @Getter
    private final ObservableField<List<String>> lsBank = new ObservableField<>(Arrays.asList("VietComBank", "TechComBank", "BIDV"));

    public final ObservableField<String> ownerName = new ObservableField<>();
    public final ObservableField<String> ownerCMND = new ObservableField<>();
    public final ObservableField<String> ownerBank = new ObservableField<>();
    public final ObservableField<String> ownerBankAddress = new ObservableField<>();
    public final ObservableField<String> ownerBankNumber = new ObservableField<>();
    public final ObservableField<Boolean> defaultBank = new ObservableField<>();

    public void Accept(){
        //TODO: save Bank
    }

    public AddBankPageViewModel(SchedulerProvider schedulerProvider) {
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
