package k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator;

import android.util.Log;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Getter;

import javax.inject.Inject;

public class BookViewModel extends BaseViewModel<BookViewNavigator> {

    //TODO: thêm vào yêu thích, đổ màu trái tim, khi không select vào trái tim thì delete khỏi yêu thích
    public final ObservableField<Image> image = new ObservableField<>();
    public final ObservableField<String> title = new ObservableField<>();
    public final ObservableField<Long> price = new ObservableField<>();
    public final ObservableField<Double> rating = new ObservableField<>(3.5);

    private final ModelRemote remote;

    public BookViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
    }

    @Getter
    private Book book;

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
                rating.set(rate.getResult());
            }
        }, throwable -> {
            Log.d("BookViewModel", "getBookRate: " + throwable.getMessage());
        });
    }

}
