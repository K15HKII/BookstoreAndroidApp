package k15hkii.se114.bookstore.ui.accountscreen.voucherscreen;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import java.util.Arrays;
import java.util.List;

public class VoucherPageViewModel extends BaseViewModel<VoucherPageNavigator> implements Observable {

    private final MutableLiveData<List<VoucherViewModel>> voucherListItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new VoucherViewModel("20% Giảm giá"),
                          new VoucherViewModel("30% Giảm giá"))
    );
    public List<VoucherViewModel> getVoucherListItems() {
        return voucherListItemsLiveData.getValue();
    }

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
