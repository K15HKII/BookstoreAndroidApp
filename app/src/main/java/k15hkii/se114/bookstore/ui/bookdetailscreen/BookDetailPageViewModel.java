package k15hkii.se114.bookstore.ui.bookdetailscreen;

import android.util.Log;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.model.api.Image;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import lombok.Setter;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class BookDetailPageViewModel extends BaseViewModel<BookDetailPageNavigator> implements Observable {

    private final ObservableField<List<Comment>> commentItemsLiveData = new ObservableField<>();
    public List<Comment> getCommentItems() {
        return commentItemsLiveData.get();
    }
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> price = new ObservableField<>();
    public final ObservableField<String> description = new ObservableField<>();
    public final ObservableField<String> remainQuantity = new ObservableField<>();
    @Inject protected ModelRemote remote;
    private Book book;

    public void setBook(Book book) {
        this.book = book;
        name.set(book.getTitle());
        price.set(String.valueOf(book.getPrice()));
        description.set(book.getDescription());
        price.set(String.valueOf(book.getStock()));
    }

    public BookDetailPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    public void openBuyNowDialog(){
        getNavigator().openBuyNowDialog(book);
    }

    public void openOnCartDialog(){
        getNavigator().openOnCartDialog();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
}
