package k15hkii.se114.bookstore.ui.notificationnews;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;
import k15hkii.se114.bookstore.data.model.api.bill.Bill;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NotificationPageViewModel extends BaseViewModel<NotificationPageNavigator> implements Observable {


    private final ModelRemote remote;
    private final ViewModelMapper mapper;
    private final UUID userId;

    public final ObservableArrayList<NotificationOrderViewModel> notifications = new ObservableArrayList<>();

    public NotificationPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, ViewModelMapper mapper, UUID userId) {
        super(schedulerProvider);
        this.remote = remote;
        this.mapper = mapper;
        this.userId = userId;
        loadData();
    }

    @SuppressLint("LongLogTag")
    public void loadData() {
        dispose(remote.getBills(userId)
                .map(bills -> {
                    List<NotificationOrderViewModel> list = new ArrayList<>();
                    for (Bill bill : bills) {
                        NotificationOrderViewModel vm = new NotificationOrderViewModel(getSchedulerProvider(), mapper, remote);
                        vm.setBill(bill);
                        list.add(vm);
                    }
                    return list;
                }), notifications -> {
            this.notifications.clear();
            this.notifications.addAll(notifications);
        }, throwable -> {
            Log.d("NotificationPageViewModel", "loadData: " + throwable.getMessage());
        });
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

    public void openVoucherPage() {
        getNavigator().openVoucherPage();
    }

}
