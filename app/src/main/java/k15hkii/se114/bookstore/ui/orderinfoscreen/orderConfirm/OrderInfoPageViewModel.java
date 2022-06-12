package k15hkii.se114.bookstore.ui.orderinfoscreen.orderConfirm;

import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.orderinfoscreen.BaseOrderInfoViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class OrderInfoPageViewModel extends BaseOrderInfoViewModel<OrderInfoPageNavigator> {

    // TODO: T nghĩ cần BillRequest để gắn phương thức thanh toán, địa chỉ, đơn hàng, voucher này kia
    // ở đây set data cho view thì bill chưa được tạo, bấm nút đặt hàng rồi thì mới post bill

    public OrderInfoPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, ViewModelMapper mapper) {
        super(schedulerProvider, mapper, remote);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    public void openSuccessOrder(){
        getNavigator().SucceedOrder();
    }

}
