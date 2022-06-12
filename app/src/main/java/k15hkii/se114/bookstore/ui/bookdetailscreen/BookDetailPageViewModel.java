package k15hkii.se114.bookstore.ui.bookdetailscreen;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableLong;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.data.model.api.user.FavouriteBookCRUDRequest;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

public class BookDetailPageViewModel extends BaseViewModel<BookDetailPageNavigator> implements Observable {
    //TODO: thêm vào yêu thích, đổ màu trái tim, khi không select vào trái tim thì delete khỏi yêu thích
    private final ObservableField<List<FeedbackViewModel>> commentItemsLiveData = new ObservableField<>();
    public List<FeedbackViewModel> getCommentItems() {
        return commentItemsLiveData.get();
    }
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableLong price = new ObservableLong();
    public final ObservableField<String> description = new ObservableField<>();
    public final ObservableField<Image> image = new ObservableField<>();
    public final ObservableField<String> remainQuantity = new ObservableField<>();
    public final ObservableBoolean isFavorite = new ObservableBoolean();

    protected final ModelRemote remote;
    private final UUID userId;

    private Book book;

    public void setBook(Book book) {
        this.book = book;
        name.set(book.getTitle());
        price.set(book.getPrice());
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

    public BookDetailPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, UUID userId) {
        super(schedulerProvider);
        this.remote = remote;
        this.userId = userId;
    }

    //TODO: Binding
    public void toggleFavourite() {
        isFavorite.set(!isFavorite.get());
        FavouriteBookCRUDRequest request = new FavouriteBookCRUDRequest();
        request.setBookId(book.getId());
        request.setSelected(isFavorite.get());

        dispose(remote.createFavoriteBook(userId, request),
                response -> {

                }, throwable -> {

                });
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
