package k15hkii.se114.bookstore.ui;

import io.reactivex.Single;
import k15hkii.se114.bookstore.data.model.api.bill.Bill;
import k15hkii.se114.bookstore.data.model.api.bill.BillDetail;
import k15hkii.se114.bookstore.data.model.api.bill.BillStatus;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.data.model.api.lend.Lend;
import k15hkii.se114.bookstore.data.model.api.user.UserBank;
import k15hkii.se114.bookstore.data.model.api.voucher.Voucher;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.accountscreen.voucherscreen.VoucherViewModel;
import k15hkii.se114.bookstore.ui.accountscreen.voucherscreen.adapterSelect.VoucherItemAdapterViewModel;
import k15hkii.se114.bookstore.ui.bankscreen.recycleViewBankSelector.OtherBankViewModel;
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
                BookViewModel vm = new BookViewModel(schedulerProvider, remote);
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

    // VOUCHER MAPPER
    public Single<List<VoucherViewModel>> toVoucherViewModel(Single<List<Voucher>> single) {
        return single.map(vouchers -> {
            List<VoucherViewModel> list = new ArrayList<>();
            for (Voucher voucher : vouchers) {
                VoucherViewModel vm = new VoucherViewModel(schedulerProvider, remote);
                vm.setVoucher(voucher);
                list.add(vm);
            }
            return list;
        });
    }

    public Single<List<VoucherItemAdapterViewModel>> toSelectVoucherViewModel(Single<List<Voucher>> single) {
        return single.map(vouchers -> {
            List<VoucherItemAdapterViewModel> list = new ArrayList<>();
            for (Voucher voucher : vouchers) {
                VoucherItemAdapterViewModel vm = new VoucherItemAdapterViewModel(schedulerProvider, remote);
                vm.setVoucher(voucher);
                list.add(vm);
            }
            return list;
        });
    }


    // ORDER MAPPER

    public Single<List<OrderViewViewModel>> toOrderViewModel(Single<List<Bill>> single, BillStatus type) {
        return single.map(bills -> {
            List<OrderViewViewModel> list = new ArrayList<>();
            for (Bill bill : bills) {
                if (bill.getStatus() == type) {
                    OrderViewViewModel vm = new OrderViewViewModel(this.schedulerProvider, remote);
                    vm.setBill(bill);
                    list.add(vm);
                }
            }
            return list;
        });
    }

    public Single<List<OrderViewViewModel>> toOrderViewViewModel(Single<List<Bill>> single) {
        return single.map(bills -> {
            List<OrderViewViewModel> list = new ArrayList<>();
            for (Bill bill : bills) {
                OrderViewViewModel vm = new OrderViewViewModel(this.schedulerProvider, remote);
                vm.setBill(bill);
                list.add(vm);
            }
            return list;
        });
    }

    public Single<List<OrderViewViewModel>> toOrderViewViewModel(Single<List<Bill>> single, BillStatus type) {
        return toOrderViewViewModel(single.toObservable().flatMapIterable(bills -> bills)
                .filter(bill -> bill.getStatus() == type)
                .toList());
    }

    public Single<List<OrderViewViewModel>> toShippingOrderViewModel(Single<List<Bill>> single) {
        return toOrderViewViewModel(single, BillStatus.TRANSPORTING);
    }

    public Single<List<OrderViewViewModel>> toShipmentArrivedOrderViewModel(Single<List<Bill>> single) {
        return toOrderViewViewModel(single);
    }

    public Single<List<OrderViewViewModel>> toRatingOrderViewModel(Single<List<Bill>> single) {
        return toOrderViewViewModel(single);
    }

    @NotNull
    private Single<List<OrderViewViewModel>> toCompletedOrderViewViewModel(Single<List<Bill>> single) {
        return toOrderViewViewModel(single, BillStatus.COMPLETED);
    }

    public Single<List<OrderViewViewModel>> toCanceledOrderViewModel(Single<List<Bill>> single) {
        return toOrderViewViewModel(single, BillStatus.CANCELED);
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

    public Single<List<VoucherViewModel>> getVouchers(UUID userId) {
        return toVoucherViewModel(remote.getVouchers(userId));
    }

    public Single<List<VoucherItemAdapterViewModel>> getSelectVouchers(UUID userId) {
        return toSelectVoucherViewModel(remote.getVouchers(userId));
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

    public Single<List<OrderBookViewModel>> getBillDetails(int billId) {
        return remote.getBill(billId).map(bill -> {
            return toOrderBookViewModels(bill.getBillDetails());
        });
    }

    @NotNull
    public List<OrderBookViewModel> toOrderBookViewModels(List<BillDetail> details) {
        List<OrderBookViewModel> list = new ArrayList<>();
        for (BillDetail billDetail : details) {
            OrderBookViewModel viewModel = new OrderBookViewModel(this.schedulerProvider, remote);
            viewModel.setOrderDetail(billDetail);
            list.add(viewModel);
        }
        return list;
    }

    public Single<List<OrderItemViewModel>> getBillItem(int billId) {
        return remote.getBill(billId).map(bill -> {
            List<OrderItemViewModel> list = new ArrayList<>();
            for (BillDetail billDetail : bill.getBillDetails()) {
                OrderItemViewModel viewModel = new OrderItemViewModel(this.schedulerProvider, remote);
                viewModel.setBillDetail(billDetail);
                list.add(viewModel);
            }
            return list;
        });
    }

    public Single<List<OrderViewViewModel>> getBills(UUID userId) {
        return toOrderViewViewModel(remote.getBills(userId));
    }

    public Single<List<OrderViewViewModel>> getBills(UUID userId, BillStatus type) {
        return toOrderViewViewModel(remote.getBills(userId), type);
    }

}
