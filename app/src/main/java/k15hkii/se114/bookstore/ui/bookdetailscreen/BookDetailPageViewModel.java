package k15hkii.se114.bookstore.ui.bookdetailscreen;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.List;

public class BookDetailPageViewModel extends BaseViewModel<BookDetailPageNavigator> implements Observable {
    //TODO: thêm vào yêu thích, đổ màu trái tim, khi không select vào trái tim thì delete khỏi yêu thích
    private final ObservableField<List<Comment>> commentItemsLiveData = new ObservableField<>();
    public List<Comment> getCommentItems() {
        return commentItemsLiveData.get();
    }
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> price = new ObservableField<>();
    public final ObservableField<String> description = new ObservableField<>();
    public final ObservableField<Image> image = new ObservableField<>();
    public final ObservableField<String> remainQuantity = new ObservableField<>();
    @Inject protected ModelRemote remote;

    private Book book;
    public void setBook(Book book) {
        this.book = book;
        name.set(book.getTitle());
        price.set(String.valueOf(book.getPrice()) + " đ");
        description.set(book.getDescription());
        remainQuantity.set(String.valueOf(book.getStock()));
        image.set(book.getImages().get(0));
    }

    @Override
    public void initializeFromBundle(@NonNull @NotNull Bundle bundle) {
        super.initializeFromBundle(bundle);
        Book book = (Book) bundle.getSerializable("book");
        if(book != null) setBook(book);
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
        getNavigator().openOnCartDialog(book);
    }

    public void openRatingBook() {
        getNavigator().openRatingBook();
    }

}
