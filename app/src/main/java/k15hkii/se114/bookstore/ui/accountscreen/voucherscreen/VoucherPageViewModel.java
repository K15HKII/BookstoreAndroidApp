package k15hkii.se114.bookstore.ui.accountscreen.voucherscreen;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import java.util.Arrays;
import java.util.List;

public class VoucherPageViewModel extends BaseViewModel<VoucherPageNavigator> implements Observable {

    public final ObservableField<List<VoucherViewModel>> listvoucher = new ObservableField<>(
            Arrays.asList(new VoucherViewModel("20% Giảm giá"),
                          new VoucherViewModel("30% Giảm giá"))
    );

    public VoucherPageViewModel(SchedulerProvider schedulerProvider) {
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
