package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab.detail;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.model.api.Image;
import k15hkii.se114.bookstore.data.model.api.Lend;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.UUID;

public class RentDetailBillViewModel extends BaseViewModel<RentDetailBillNavigator> implements Observable {
    public RentDetailBillViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
    }

    public final ObservableField<String> bookName = new ObservableField<>(); //title
    public final ObservableField<String> bookType = new ObservableField<>(); //description
    public final ObservableField<Image> bookImage = new ObservableField<>();
    public final ObservableField<String> bookRentPrice = new ObservableField<>();
    public final ObservableField<String> expiredDate = new ObservableField<>();
    public final ObservableField<String> voucherInfo = new ObservableField<>();
    public final ObservableField<String> paymentMethod = new ObservableField<>();
    public final ObservableField<String> rentPrice = new ObservableField<>();
    public final ObservableField<String> discount = new ObservableField<>();
    public final ObservableField<String> totalPrice = new ObservableField<>();

    @Inject
    protected ModelRemote remote;
    @Getter
    private Book book;
    private Lend lend;

    public void getData(UUID id) {
        getCompositeDisposable().add(remote.getBook(id)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .doOnSuccess(book -> {
                    this.book = book;
                    this.bookName.set(this.book.getTitle());
                    this.bookImage.set(this.book.getImages().get(0));
                    this.bookRentPrice.set(String.valueOf(this.book.getPrice()));
                    this.totalPrice.set(String.valueOf(this.book.getPrice()));
                }).subscribe());
    }
    public void setLend(Lend lend){
        this.lend=lend;
        getData(this.lend.getBookId());
        this.expiredDate.set(String.valueOf(this.lend.getEndDate()));
    }
    @Override
    public void initializeFromBundle(@NonNull @NotNull Bundle bundle) {
        super.initializeFromBundle(bundle);
        if (bundle.containsKey("lending")) {
            Lend lending = (Lend) bundle.getSerializable("lending");
            if(lending != null) setLend(lending);
        }
        if (bundle.containsKey("lended")) {
            Lend lended = (Lend) bundle.getSerializable("lended");
            if(lended != null) setLend(lended);
        }
    }
    public void onBackWardClick(){
        getNavigator().BackWard();
    }
}
