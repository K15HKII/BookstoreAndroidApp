package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.model.api.BookTag;
import k15hkii.se114.bookstore.data.model.api.Lend;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.UUID;

//@AllArgsConstructor
public class RentViewViewModel extends BaseViewModel<RentViewNavigator> implements Observable {

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> booktag = new ObservableField<>();
    public final ObservableField<String> price = new ObservableField<>();
    public final ObservableField<String> rentNote = new ObservableField<>();
    public final ObservableField<String> rentPrice = new ObservableField<>();
    public final ObservableField<String> description = new ObservableField<>();

    @Inject protected ModelRemote remote;
    private Lend lend;
    private Book book;
    public void setLend(Lend lend){
        if(lend==null) return;
        this.lend=lend;
        getData(this.lend.getBookId());
    }

    public void getData(UUID id) {
        getCompositeDisposable().add(remote.getBook(id)
               .subscribeOn(getSchedulerProvider().io())
               .observeOn(getSchedulerProvider().ui())
               .doOnSuccess(book -> {
                   String bt = "";
                   this.book = book;
                   this.name.set(book.getTitle());
                   this.price.set(String.valueOf(book.getPrice()));
                   for (BookTag tag : book.getBooktags()) {
                       bt+= tag.name() + " ";
                   }
                   booktag.set(bt);
               }).subscribe());
    }


    public RentViewViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
    }


    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
}
