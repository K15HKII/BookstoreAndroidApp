package k15hkii.se114.bookstore.ui;

import io.reactivex.Single;
import k15hkii.se114.bookstore.data.model.api.*;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentViewViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderItemAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderItemViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderViewViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import k15hkii.se114.bookstore.ui.ratingbookscreen.RatingReportViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Singleton
public class ViewModelMapper {

    private final ModelRemote remote;

    @Inject
    public ViewModelMapper(ModelRemote remote) {
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
                RentViewViewModel vm = new RentViewViewModel();
                vm.setLend(lend);
                list.add(vm);
            }
            return list;
        });
    }

    // ORDER MAPPER

    public Single<List<OrderViewViewModel>> toOrderViewModel(Single<List<Bill>> single) {
        return single.map(bills -> {
            List<OrderViewViewModel> list = new ArrayList<>();
            for (Bill bill : bills) {
                OrderViewViewModel vm = new OrderViewViewModel(remote);
                vm.setBill(bill);
                list.add(vm);
            }
            return list;
        });
    }

    public Single<List<OrderViewViewModel>> toWaitingOrderViewModel(Single<List<Bill>> single) {
        return single.map(bills -> {
            List<OrderViewViewModel> list = new ArrayList<>();
            for (Bill bill : bills) {
                if (bill.getStatus().toString().equals(BillStatus.WAITING.toString())) {
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

    public Single<List<OrderViewViewModel>> toRatingOrderViewModel(Single<List<Bill>> single) {
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

    public Single<List<RatingReportViewModel>> toRatingViewModel(Single<List<Bill>> single) {
        return single.map(bills -> {
            List<RatingReportViewModel> list = new ArrayList<>();
            for (Bill bill : bills) {
                RatingReportViewModel vm = new RatingReportViewModel();
                vm.setRate(bill);
                list.add(vm);
            }
            return list;
        });
    }

    public Single<List<RatingReportViewModel>> getRatings(UUID uuid) {
        return toRatingViewModel(remote.getBills(uuid));
    }

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
                OrderBookViewModel viewModel = new OrderBookViewModel();
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
        return toWaitingOrderViewModel(remote.getBills(userId));
    }

    public Single<List<OrderViewViewModel>> getShippingBills(UUID userId) {
        return toShippingOrderViewModel(remote.getBills(userId));
    }

    public Single<List<OrderViewViewModel>> getCompletedBills(UUID userId) {
        return toShipmentArrivedOrderViewModel(remote.getBills(userId));
    }

    public Single<List<OrderViewViewModel>> getRatingBills(UUID userId) {
        return toRatingOrderViewModel(remote.getBills(userId));
    }

    public Single<List<OrderViewViewModel>> getCancelBills(UUID userId) {
        return toCanceledOrderViewModel(remote.getBills(userId));
    }

}
