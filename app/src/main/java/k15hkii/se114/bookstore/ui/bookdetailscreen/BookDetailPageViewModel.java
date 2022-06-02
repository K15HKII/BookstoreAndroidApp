package k15hkii.se114.bookstore.ui.bookdetailscreen;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.model.api.Image;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class BookDetailPageViewModel extends BaseViewModel<BookDetailPageNavigator> implements Observable {

    private final ObservableField<List<Comment>> commentItemsLiveData = new ObservableField<>(
            Arrays.asList(new Comment("tritran@gm.com"),
                          new Comment("tritran12@gm.com"))
    );
    public List<Comment> getCommentItems() {
        return commentItemsLiveData.get();
    }

    @Inject protected ModelRemote remote;

    private String bookProfileId;

    private Book profile;
    private Image[] image;

    public void getData(UUID id) {
        remote.getBook(id).doOnSuccess(bookProfile -> {
            profile = bookProfile;
        }).subscribe();
        // Todo: lay image
    }

    public BookDetailPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    public void openBuyNowDialog(){
        getNavigator().openBuyNowDialog();
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
    // TODO: Implement the ViewModel
}
