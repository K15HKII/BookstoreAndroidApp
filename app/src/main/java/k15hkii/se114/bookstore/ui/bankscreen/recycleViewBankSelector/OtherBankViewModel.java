package k15hkii.se114.bookstore.ui.bankscreen.recycleViewBankSelector;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;

public class OtherBankViewModel extends BaseViewModel<IOtherBankNavigator> implements Observable {
    @Inject
    protected ModelRemote remote;

    public final ObservableField<String> bank = new ObservableField<>();

    public OtherBankViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }
    public OtherBankViewModel(String Bank) {
        super(null);
        this.bank.set(Bank);
    }
}
