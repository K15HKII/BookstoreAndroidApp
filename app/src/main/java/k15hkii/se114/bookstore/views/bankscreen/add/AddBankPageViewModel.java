package k15hkii.se114.bookstore.views.bankscreen.add;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class AddBankPageViewModel extends BaseViewModel<AddBankPageNavigator> implements Observable {
    @Getter
    private final MutableLiveData<List<String>> testSource = new MutableLiveData<>(Arrays.asList("VietComBank", "TechComBank", "BIDV"));

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
