package k15hkii.se114.bookstore.ui;

import io.reactivex.Single;
import k15hkii.se114.bookstore.data.model.api.bill.Bill;
import k15hkii.se114.bookstore.data.model.api.bill.BillDetail;
import k15hkii.se114.bookstore.data.model.api.bill.BillStatus;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.data.model.api.lend.Lend;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentViewViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderItemViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderViewViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Singleton
public class ViewModelMapper {

    private final ModelRemote remote;
    private final SchedulerProvider schedulerProvider;

    @Inject
    public ViewModelMapper(SchedulerProvider schedulerProvider, ModelRemote remote) {
        this.schedulerProvider = schedulerProvider;
        this.remote = remote;
    }

    public Single<List<BookViewModel>> toBookViewModel(Single<List<Book>> single) {
        return single.map(books -> {
            List<BookViewModel> list = new ArrayList<>();
            for (Book book : books) {
                BookViewModel vm = new BookViewModel();
                vm.setBook(book);
                list.add(vm);
            }
            return list;
        });
    }

    public Single<List<RentViewViewModel>> toLendViewModel(Single<List<Lend>> single) {
        return single.map(lends -> {
            List<RentViewViewModel> list = new ArrayList<>();
            for (Lend lend : lends) {
                RentViewViewModel vm = new RentViewViewModel(schedulerProvider, remote);
                vm.setLend(lend);
                list.add(vm);
            }
            return list;
        });
    }

    // ORDER MAPPER

    public Single<List<OrderViewViewModel>> toOrderViewModel(Single<List<Bill>> single, String type) {
        return single.map(bills -> {
            List<OrderViewViewModel> list = new ArrayList<>();
            for (Bill bill : bills) {
                if (bill.getStatus().toString().equals(type)) {
                    OrderViewViewModel vm = new OrderViewViewModel(remote);
                    vm.setBill(bill);
                    list.add(vm);
                }
            }
            return list;
        });
    }

    public Single<List<OrderViewViewModel>> toShippingOrderViewModel(Single<List<Bill>> single) {
        return single.map(bills -> {
            List<OrderViewViewModel> list = new ArrayList<>();
            for (Bill bill : bills) {
                if (bill.getStatus().toString().equals(BillStatus.PROCESSING.toString())) {
                    OrderViewViewModel vm = new OrderViewViewModel(remote);
                    vm.setBill(bill);
                    list.add(vm);
                }
            }
            return list;
        });
    }

    public Single<List<OrderViewViewModel>> toShipmentArrivedOrderViewModel(Single<List<Bill>> single) {
        return toOrderViewViewModel(single);
    }

    public Single<List<OrderViewViewModel>> toRatingOrderViewModel(Single<List<Bill>> single) {
        return toOrderViewViewModel(single);
    }

    @NotNull
    private Single<List<OrderViewViewModel>> toOrderViewViewModel(Single<List<Bill>> single) {
        return single.map(bills -> {
            List<OrderViewViewModel> list = new ArrayList<>();
            for (Bill bill : bills) {
                if (bill.getStatus().toString().equals(BillStatus.COMPLETED.toString())) {
                    OrderViewViewModel vm = new OrderViewViewModel(remote);
                    vm.setBill(bill);
                    list.add(vm);
                }
            }
            return list;
        });
    }

    public Single<List<OrderViewViewModel>> toCanceledOrderViewModel(Single<List<Bill>> single) {
        return single.map(bills -> {
            List<OrderViewViewModel> list = new ArrayList<>();
            for (Bill bill : bills) {
                if (bill.getStatus().toString().equals(BillStatus.CANCELED.toString())) {
                    OrderViewViewModel vm = new OrderViewViewModel(remote);
                    vm.setBill(bill);
                    list.add(vm);
                }
            }
            return list;
        });
    }

    // RATING MAPPER

//    public Single<List<RatingReportViewModel>> toRatingViewModel(Single<List<Bill>> single) {
//        return single.map(bills -> {
//            List<RatingReportViewModel> list = new ArrayList<>();
//            for (Bill bill : bills) {
//                RatingReportViewModel vm = new RatingReportViewModel();
//                vm.setRate(bill);
//                list.add(vm);
//            }
//            return list;
//        });
//    }
//
//    public Single<List<RatingReportViewModel>> getRatings(UUID uuid) {
//        return toRatingViewModel(remote.getBills(uuid));
//    }

    public Single<List<RentViewViewModel>> getLends(UUID userId) {
        return toLendViewModel(remote.getLends(userId));
    }

    public Single<List<BookViewModel>> getRecentBooks(UUID userId) {
        return toBookViewModel(remote.getRecentBooks(userId));
    }

    public Single<List<BookViewModel>> getFavouriteBooks(UUID userId) {
        return toBookViewModel(remote.getFavoriteBooks(userId));
    }

    public Single<List<BookViewModel>> getBooks() {
        return toBookViewModel(remote.getBooks());
    }

    public Single<List<OrderBookViewModel>> getBill(int billId) {
        return remote.getBill(billId).map(bill -> {
            List<OrderBookViewModel> list = new ArrayList<>();
            for (BillDetail billDetail : bill.getBillDetails()) {
                OrderBookViewModel viewModel = new OrderBookViewModel(remote);
                viewModel.setOrderDetail(billDetail);
                list.add(viewModel);
            }
            return list;
        });
    }

    public Single<List<OrderItemViewModel>> getBillItem(int billId) {
        return remote.getBill(billId).map(bill -> {
            List<OrderItemViewModel> list = new ArrayList<>();
            for (BillDetail billDetail : bill.getBillDetails()) {
                OrderItemViewModel viewModel = new OrderItemViewModel(remote);
                viewModel.setBillDetail(billDetail);
                list.add(viewModel);
            }
            return list;
        });
    }

    public Single<List<OrderViewViewModel>> getBills(UUID userId) {
        return remote.getBills(userId).map(bills -> {
            List<OrderViewViewModel> list = new ArrayList<>();
            for (Bill bill : bills) {
                OrderViewViewModel viewModel = new OrderViewViewModel(remote);
                viewModel.setBill(bill);
                list.add(viewModel);
            }
            return list;
        });
    }

    public Single<List<OrderViewViewModel>> getWaitingBills(UUID userId) {
        return toOrderViewModel(remote.getBills(userId), BillStatus.WAITING.name());
    }

    public Single<List<OrderViewViewModel>> getShippingBills(UUID userId) {
        return toOrderViewModel(remote.getBills(userId), BillStatus.TRANSPORTING.name());
    }

    public Single<List<OrderViewViewModel>> getCompletedBills(UUID userId) {
        return toOrderViewModel(remote.getBills(userId), BillStatus.COMPLETED.name());
    }

    public Single<List<OrderViewViewModel>> getRatingBills(UUID userId) {
        return toOrderViewModel(remote.getBills(userId), BillStatus.CANCELED.name());
    }

    public Single<List<OrderViewViewModel>> getCancelBills(UUID userId) {
        return toOrderViewModel(remote.getBills(userId), BillStatus.TRANSPORTING.toString());
    }

}
