package k15hkii.se114.bookstore.ui;

import io.reactivex.Single;
import k15hkii.se114.bookstore.data.model.api.Bill;
import k15hkii.se114.bookstore.data.model.api.BillDetail;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.model.api.Lend;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentViewViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import k15hkii.se114.bookstore.ui.ratingbookscreen.RatingReportViewModel;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Singleton
public class ViewModelRemote {

    private final ModelRemote remote;

    @Inject
    public ViewModelRemote(ModelRemote remote) {
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

}
