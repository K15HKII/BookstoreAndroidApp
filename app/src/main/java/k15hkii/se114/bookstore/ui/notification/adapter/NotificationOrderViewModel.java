package k15hkii.se114.bookstore.ui.notification.adapter;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.data.model.api.bill.Bill;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.notification.NotificationViewNavigator;
import k15hkii.se114.bookstore.ui.order.BaseOrderInfoViewModel;
import k15hkii.se114.bookstore.ui.order.adapter.OrderBookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class NotificationOrderViewModel extends NotificationViewModel {

    private final BaseOrderInfoViewModel<NotificationViewNavigator> _base;

    public NotificationOrderViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, ModelRemote remote) {
        super(schedulerProvider);
        _base = new BaseOrderInfoViewModel<>(schedulerProvider, mapper, remote);
        _base.items.addOnPropertyChangedCallback(new OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                OrderBookViewModel vm = _base.items.get() != null && _base.items.get().size() > 0 ? _base.items.get().get(0) : null;
                if (vm != null) {
                    notificationImage.set(vm.image.get());
                    vm.image.addOnPropertyChangedCallback(new OnPropertyChangedCallback() {
                        @Override
                        public void onPropertyChanged(Observable sender, int propertyId) {
                            if (vm.image.get() != null) {
                                notificationImage.set(vm.image.get());
                            }
                        }
                    });
                }
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
        String title = null;
        String content = null;

        Bill bill = _base.getBill();
        if (bill != null && bill.getStatus() != null) {
            switch (bill.getStatus()) {
                case WAITING:
                    title = "????n h??ng c???a b???n ??ang ch??? x??? l??";
                    content = "Ng???i y??n v?? ?????i b???n m??nh x??? l?? ????n h??ng cho nh??!";
                    break;
                case TRANSPORTING:
                    title = "????n h??ng c???a b???n ??ang ???????c v???n chuy???n";
                    content = "C??c ch?? shipper ??ang v???n chuy???n ????n h??ng ?????n tay b???n, c??? g???ng ?????i nha!";
                    break;
                case CANCELED:
                    title = "????n h??ng c???a b???n ???? b??? h???y";
                    content = "????n h??ng c???a b???n ???? b??? h???y, vui l??ng li??n h??? v???i t???i m??nh ????? bi???t th??m chi ti???t!";
                    break;
                default:
                    break;
            }
        }

        notificationTitle.set(title);
        notificationContent.set(content);
    }

}
