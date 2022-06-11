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
    public final ObservableField<List<String>> lsBank = new ObservableField<>(Arrays.asList("VietComBank", "TechComBank", "BIDV"));
    @Getter
    public final ObservableField<String> name = new ObservableField<>();
    @Getter
    public final ObservableField<String> iban = new ObservableField<>();
//    public final ObservableField<String> bankName = new ObservableField<>();
//    public final ObservableField<String> bankId = new ObservableField<>();
//    public final ObservableField<String> branch = new ObservableField<>();
//    public final ObservableField<Boolean> defaultBank = new ObservableField<>();

    public void Accept(){
        //TODO: save Bank
    }

    public AddBankPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

}
