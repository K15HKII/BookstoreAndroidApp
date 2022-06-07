package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.shipmentarrived;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderViewViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderItemViewModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ShipmentArrivedViewPageViewModel extends BaseViewModel<ShipmentArrivedViewPageNavigator> implements Observable {

    public final ObservableField<List<OrderViewViewModel>> items = new ObservableField<>();

    @Inject
    protected ViewModelMapper mapper;

    private UUID userId;

    public void getData() {
        dispose(mapper.getCompletedBills(userId),
                items::set,
                throwable -> Log.d("ShipmentArrivedVPageVM", "getData: " + throwable.getMessage(), throwable));
    }

    public ShipmentArrivedViewPageViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.mapper = mapper;
        this.userId = preferencesHelper.getCurrentUserId();
        getData();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
