package k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;

public class BookViewModel extends BaseViewModel<BookViewNavigator> implements Observable {

    @Inject protected ModelRemote remote;

    private String bookProfileId;

    private Book book;

    public void setBookProfileId(String id) {
        this.bookProfileId = id;

        remote.getBook(id).doOnSuccess(bookProfile -> {
            book = bookProfile;
        }).subscribe();
        //TODO: lay data image
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

    public BookViewModel(String name) {
        super(null);
    }

    public BookViewModel() {
        super(null);
    }

    public void openDetail() {
        getNavigator().bookDetailNavigate(bookProfileId);
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
}
