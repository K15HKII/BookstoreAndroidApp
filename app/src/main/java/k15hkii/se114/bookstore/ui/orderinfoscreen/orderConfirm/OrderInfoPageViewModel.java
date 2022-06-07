package k15hkii.se114.bookstore.ui.orderinfoscreen.orderConfirm;

import android.util.Log;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.data.model.api.Bill;
import k15hkii.se114.bookstore.data.model.api.BillDetail;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderInfoPageViewModel extends BaseViewModel<OrderInfoPageNavigator> implements Observable {

    public final ObservableField<List<OrderBookViewModel>> items = new ObservableField<>();

    @Inject
    protected ModelRemote remote;

    private Bill bill;
    public void getData(int billId) {
        /*getCompositeDisposable().add(remote.getBill(billId)
              .subscribeOn(getSchedulerProvider().io())
              .observeOn(getSchedulerProvider().ui())
              .subscribe(bill -> {
                  List<OrderBookViewModel> list = new ArrayList<>();
                  for (BillDetail billDetail : bill.getBillDetails()) {
                      OrderBookViewModel viewModel = new OrderBookViewModel();
                      viewModel.setOrderDetail(billDetail);
                      list.add(viewModel);
                  }
                  items.set(list);
              }, throwable -> {
                  Log.d("OrderInfoPageViewModel", "getData: " + throwable.getMessage(), throwable);
              }));*/

        //TODO:
    }

    @Bindable
    public String getAddress() {
        return null;
    }

    @Bindable
    public String getPrice() {
        return "20";
    }

    @Bindable
    public String getVoucher() {
        return "";
    }

    public OrderInfoPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    public void openSuccessOrder(){
        getNavigator().SucceedOrder();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
