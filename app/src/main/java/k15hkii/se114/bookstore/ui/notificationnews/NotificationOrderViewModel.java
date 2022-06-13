package k15hkii.se114.bookstore.ui.notificationnews;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.bill.Bill;
import k15hkii.se114.bookstore.data.model.api.bill.BillStatus;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.orderinfoscreen.BaseOrderInfoViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
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
        if (bill != null) {
            switch (bill.getStatus()) {
                case WAITING:
                    title = "Đơn hàng của bạn đang chờ xử lý";
                    content = "Ngồi yên và đợi bọn mình xử lý đơn hàng cho nhé!";
                    break;
                case TRANSPORTING:
                    title = "Đơn hàng của bạn đang được vận chuyển";
                    content = "Các chú shipper đang vận chuyển đơn hàng đến tay bạn, cố gắng đợi nha!";
                    break;
                case CANCELED:
                    title = "Đơn hàng của bạn đã bị hủy";
                    content = "Đơn hàng của bạn đã bị hủy, vui lòng liên hệ với tụi mình để biết thêm chi tiết!";
                    break;
                default:
                    break;
            }
        }

        notificationTitle.set(title);
        notificationContent.set(content);
    }

}
