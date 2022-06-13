package k15hkii.se114.bookstore.ui.ratingbookscreen;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableDouble;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableFloat;
import io.reactivex.Observable;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.data.model.api.book.BookTag;
import k15hkii.se114.bookstore.data.model.api.file.File;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.data.model.api.message.FeedbackCRUDRequest;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.utils.RemoteUtils;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class RateDetailViewModel extends BaseViewModel<RatingBooksDetailPageNavigator> {

    protected ViewModelMapper mapper;
    private final ModelRemote remote;

    private final UUID userId;

    public final ObservableField<String> comment = new ObservableField<>();
    public final ObservableField<List<Uri>> imageUris = new ObservableField<>(new LinkedList<>());
    public final ObservableField<List<Uri>> videoUris = new ObservableField<>(new LinkedList<>());
    public final ObservableFloat rating = new ObservableFloat();

    private Book book;

    @Bindable
    public Image getBookImage() {
        return book == null || book.getImages() == null || book.getImages().size() == 0 ? null : book.getImages().get(0);
    }

    @Bindable
    public String getTitle() {
        return book == null ? null : book.getTitle();
    }

    @Bindable
    public String getDescription() {
        return book == null ? null : book.getDescription();
    }

    @Bindable
    public List<BookTag> getBookTags() {
        return book == null ? null : Arrays.asList(book.getBooktags());
    }

    public RateDetailViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, ModelRemote remote, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.mapper = mapper;
        this.remote = remote;
        this.userId = preferencesHelper.getCurrentUserId();
    }

    @Override
    public void initializeFromBundle(@NonNull @NotNull Bundle bundle) {
        super.initializeFromBundle(bundle);
        Book book = (Book) bundle.getSerializable("book");
        if (book != null) {
            setBook(book);
        }
    }

    public void setBook(Book book) {
        this.book = book;

        notifyPropertyChanged(BR.title);
        notifyPropertyChanged(BR.description);
        notifyPropertyChanged(BR.bookTags);
    }

    //TODO: Binding
    public void onClickNewImage() {
        getNavigator().selectImages();
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

    public void selectImages(Uri... uris) {
        imageUris.get().addAll(Arrays.asList(uris));
    }

    public void selectVideos(Uri... uris) {
        videoUris.get().addAll(Arrays.asList(uris));
    }

    public void postFeedback() {
        dispose(Observable.fromIterable(imageUris.get())
                        .flatMapSingle(uri -> remote.uploadImage(RemoteUtils.from(uri)))
                        .map(File::getId)
                        .toList(),
                images -> {
                    Log.d("RateDetailViewModel", "ConfirmRating: " + images.size());
                    FeedbackCRUDRequest request = new FeedbackCRUDRequest(images, null, comment.get(), userId, rating.get());
                    dispose(remote.sendFeedback(request), feedback -> {
                       //TODO: handle feedback
                        Log.d("RateDetailViewModel", "ConfirmRating: " + feedback.getId());
                    }, throwable -> {
                        Log.d("RateDetailViewModel", "ConfirmRating: " + throwable.getMessage());
                    });
                },
                throwable -> Log.d("RateDetailViewModel", "ConfirmRating: " + throwable.getMessage(), throwable));
    }

}
