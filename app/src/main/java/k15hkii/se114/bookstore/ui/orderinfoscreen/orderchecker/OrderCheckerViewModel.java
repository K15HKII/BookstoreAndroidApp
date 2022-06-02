package k15hkii.se114.bookstore.ui.orderinfoscreen.orderchecker;

import android.util.Log;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.data.model.api.BillDetail;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderCheckerViewModel extends BaseViewModel<OrderCheckerNavigator> {

    public final ObservableField<List<OrderBookViewModel>> items = new ObservableField<>();

    @Inject
    protected ModelRemote remote;

    public void getData(int billId) {
        getCompositeDisposable().add(remote.getBillDetails(billId)
                                           .subscribeOn(getSchedulerProvider().io())
                                           .observeOn(getSchedulerProvider().ui())
                                           .subscribe(billDetails -> {
                                               List<OrderBookViewModel> list = new ArrayList<>();
                                               for (BillDetail billDetail : billDetails) {
                                                   OrderBookViewModel viewModel = new OrderBookViewModel();
                                                   viewModel.setOrderDetail(billDetail);
                                                   list.add(viewModel);
                                               }
                                               items.set(list);
                                           }, throwable -> {
                                               Log.d("OrderInfoPageViewModel", "getData: " + throwable.getMessage(), throwable);
                                           }));
    }

    public OrderCheckerViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
        getData(1);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }
}
