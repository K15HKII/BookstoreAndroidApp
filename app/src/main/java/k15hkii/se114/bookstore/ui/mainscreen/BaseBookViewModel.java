package k15hkii.se114.bookstore.ui.mainscreen;

import android.util.Log;
import androidx.databinding.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.data.model.api.user.FavouriteBookCRUDRequest;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.base.INavigator;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Getter;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class BaseBookViewModel<N extends INavigator> extends BaseViewModel<N> {

    public final ObservableField<Image> image = new ObservableField<>();
    public final ObservableField<String> title = new ObservableField<>();
    public final ObservableLong price = new ObservableLong();
    public final ObservableFloat rating = new ObservableFloat(3.5f);
    public final ObservableBoolean isFavorite = new ObservableBoolean(false);
    @Getter
    private Book book;

    private final ModelRemote remote;
    private final UUID userId;

    private final Disposable favouriteDisposable;

    public BaseBookViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, UUID userId) {
        super(schedulerProvider);
        this.remote = remote;
        this.userId = userId;

        PublishSubject<Boolean> favourite = PublishSubject.create();
        isFavorite.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                favourite.onNext(isFavorite.get());
            }
        });

        favouriteDisposable = favourite.debounce(1, TimeUnit.SECONDS)
                .switchMapSingle(isFavorite -> {
                    FavouriteBookCRUDRequest request = new FavouriteBookCRUDRequest();
                    request.setBookId(book.getId());
                    request.setSelected(isFavorite);
                    if (!isFavorite) {
                        return remote.deleteFavoriteBook(userId, book.getId());
                    }
                    return remote.createFavoriteBook(userId, request);
                })
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(result -> {
                    Log.d("", "Favourite: " + result.getMessage());
                }, throwable -> {
                    Log.e("SearchBookViewViewModel", "error: ", throwable);
                });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        getCompositeDisposable().add(favouriteDisposable);
    }

    public void setBook(Book book) {
        if (book == null)
            return;
        this.book = book;
        if (book.getImages() != null && book.getImages().size() > 0) {
            image.set(book.getImages().get(0));
        }
        title.set(book.getTitle());
        price.set((long) book.getPrice());

        dispose(remote.getBookRate(book.getId()), rate -> {
            if (rate != null) {
                rating.set((float) rate.getResult());
            }
        }, throwable -> {
            Log.d("BookViewModel", "getBookRate: " + throwable.getMessage());
        });
        dispose(remote.isFavouriteBook(userId, book.getId()), isFavourite -> {
            isFavorite.set(isFavourite.getItem());
        }, throwable -> {
            Log.d("BookViewModel", "isFavouriteBook: " + throwable.getMessage());
        });
    }
}
