package k15hkii.se114.bookstore.ui.notificationnews;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.bill.Bill;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.orderinfoscreen.BaseOrderInfoViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class NotificationOrderViewModel extends NotificationViewModel {

    private final BaseOrderInfoViewModel<NotificationViewNavigator> _base;

    public NotificationOrderViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, ModelRemote remote) {
        super(schedulerProvider);
        _base = new BaseOrderInfoViewModel<>(schedulerProvider, mapper, remote);
        _base.items.addOnPropertyChangedCallback(new OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                notificationImage.set(_base.items.get() != null && _base.items.get().size() > 0 ? _base.items.get().get(0).image.get() : null);
            }
        });

        OnPropertyChangedCallback callback = new OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                updateContent();
            }
        };
        _base.price.addOnPropertyChangedCallback(callback);
        _base.address.addOnPropertyChangedCallback(callback);
        //_base.voucher.addOnPropertyChangedCallback(callback);
        _base.paymentMethod.addOnPropertyChangedCallback(callback);
        updateContent();
    }

    public void setBill(Bill bill) {
        _base.setBill(bill);
    }

    private void updateContent() {
        notificationTitle.set("test"); //TODO
        notificationContent.set("super testtttttttttttttttttttttttttttttttttttt"); //TODO
    }

}
