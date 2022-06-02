package k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.model.api.Image;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

public class BookViewModel extends BaseViewModel<BookViewNavigator> implements Observable {

    @Inject
    protected ModelRemote remote;

    private String id;
    private Book book;

    public void getData(UUID id) {
        getCompositeDisposable().add(remote.getBook(id)
               .subscribeOn(getSchedulerProvider().io())
               .observeOn(getSchedulerProvider().ui())
               .doOnSuccess(book -> {
                   this.book = book;
               }).subscribe());
    }

    public void setBookProfile(Book book) {
        this.book = book;
    }

    public BookViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    @Bindable
    public String getName() {
        return book == null ? "profile is null" : book.getTitle();
    }

    @Bindable
    public String getPrice() {
        return book == null ? "null" : "đ" + String.valueOf(book.getPrice());
    }

//    @Bindable
//    public Image getImage() {
//        return book == null ?  : book.getImages()[0];
//    }

    public BookViewModel(String name) {
        super(null);
    }

    public BookViewModel() {
        super(null);
    }

    public void openDetail() {
        getNavigator().bookDetailNavigate(id);
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
}
