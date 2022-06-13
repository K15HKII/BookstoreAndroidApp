package k15hkii.se114.bookstore.ui.notification.adapter;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.data.model.api.bill.BillDetail;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.order.adapter.OrderBookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class NotificationRatingViewModel extends NotificationViewModel {

    private final OrderBookViewModel _base;

    public Book getBook() {
        return _base.getBook();
    }

    public NotificationRatingViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider);
        _base = new OrderBookViewModel(schedulerProvider, remote);

        _base.image.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                notificationImage.set(_base.image.get());
            }
        });

        OnPropertyChangedCallback callback = new OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                updateContent();
            }
        };
        _base.price.addOnPropertyChangedCallback(callback);
        _base.quantity.addOnPropertyChangedCallback(callback);
        _base.name.addOnPropertyChangedCallback(callback);
        updateContent();
    }

    public void setBillDetail(BillDetail detail) {
        _base.setOrderDetail(detail);
    }

    private void updateContent() {
        notificationTitle.set("Chia sẻ nhận xét về sản phẩm");
        notificationContent.set("Kiện hàng đã đến tay bạn. Hãy đánh giá sản phẩm và chất lượng dịch vụ giúp chúng mình nhé!");
    }

    @Override
    public void onClick() {
        getNavigator().onClick(getBook());
    }

}
