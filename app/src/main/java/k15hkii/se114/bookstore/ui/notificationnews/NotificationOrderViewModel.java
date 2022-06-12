package k15hkii.se114.bookstore.ui.notificationnews;

import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.databinding.library.baseAdapters.BR;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderItemViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.BaseOrderInfoViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.List;

public class NotificationOrderViewModel extends BaseOrderInfoViewModel<NotificationOrderViewNavigator> {

    public final ObservableField<String> notificationTitle = new ObservableField<>();
    public final ObservableField<String> notificationContent = new ObservableField<>();

    @Bindable
    public Image getImage() {
        return items.get() != null && items.get().size() > 0 ? items.get().get(0).image.get() : null;
    }

    public NotificationOrderViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, ModelRemote remote) {
        super(schedulerProvider, mapper, remote);

        items.addOnPropertyChangedCallback(new OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(androidx.databinding.Observable sender, int propertyId) {
                notifyPropertyChanged(BR.image);
            }
        });
    }

}
