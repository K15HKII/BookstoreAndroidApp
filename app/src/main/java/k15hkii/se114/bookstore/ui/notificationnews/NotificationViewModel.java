package k15hkii.se114.bookstore.ui.notificationnews;

import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.bill.Bill;
import k15hkii.se114.bookstore.data.model.api.bill.BillDetail;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class NotificationViewModel extends BaseViewModel<NotificationViewNavigator> {

    public final ObservableField<String> notificationTitle = new ObservableField<>();
    public final ObservableField<String> notificationContent = new ObservableField<>();
    public final ObservableField<Image> notificationImage = new ObservableField<>();

    public NotificationViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public static NotificationViewModel fromBill(SchedulerProvider schedulerProvider, ViewModelMapper mapper, ModelRemote remote, Bill bill) {
        NotificationOrderViewModel vm = new NotificationOrderViewModel(schedulerProvider, mapper, remote);
        vm.setBill(bill);
        return vm;
    }

    public static NotificationViewModel fromBillDetail(SchedulerProvider schedulerProvider, ModelRemote remote, BillDetail detail) {
        NotificationRatingViewModel vm = new NotificationRatingViewModel(schedulerProvider, remote);
        vm.setBillDetail(detail);
        return vm;
    }

    public void onClick() {

    }

}
