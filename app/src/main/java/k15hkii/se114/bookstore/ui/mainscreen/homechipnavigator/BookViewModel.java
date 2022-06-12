package k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.data.model.api.user.FavouriteBookCRUDRequest;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.BaseBookViewModel;
import k15hkii.se114.bookstore.ui.searchbook.SearchBookViewViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Getter;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class BookViewModel extends BaseBookViewModel<BookViewNavigator> {

    public BookViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, UUID userId) {
        super(schedulerProvider, remote, userId);
    }

}
