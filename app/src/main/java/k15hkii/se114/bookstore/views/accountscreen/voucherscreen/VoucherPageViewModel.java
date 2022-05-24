package k15hkii.se114.bookstore.views.accountscreen.voucherscreen;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.orderitemsrecycleview.OrderView;

import java.util.Arrays;
import java.util.List;

public class VoucherPageViewModel extends BaseViewModel<VoucherPageNavigator> implements Observable {

    private final MutableLiveData<List<Voucher>> voucherListItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new Voucher("20% Giảm giá"),
                          new Voucher("30% Giảm giá"))
    );
    public List<Voucher> getVoucherListItems() {
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
