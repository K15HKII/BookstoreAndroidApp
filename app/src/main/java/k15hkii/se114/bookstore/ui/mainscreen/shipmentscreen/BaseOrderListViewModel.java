package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen;

import android.util.Log;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.bill.BillStatus;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.base.INavigator;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderViewViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import java.util.List;
import java.util.UUID;

public class BaseOrderListViewModel<N extends INavigator> extends BaseViewModel<N> {

    public final ObservableField<List<OrderViewViewModel>> items = new ObservableField<>();

    protected ViewModelMapper mapper;

    private final BillStatus status;
    private final UUID userId;

    public void getData() {
        dispose(mapper.getBills(userId, status),
                items::set,
                throwable -> Log.d(getClass().getSimpleName(), "getData: " + throwable.getMessage(), throwable));
    }

    public BaseOrderListViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, BillStatus status, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.mapper = mapper;
        this.status = status;
        this.userId = preferencesHelper.getCurrentUserId();
        getData();
    }

}
