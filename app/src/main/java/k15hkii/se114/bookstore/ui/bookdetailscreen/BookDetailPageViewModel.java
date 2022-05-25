package k15hkii.se114.bookstore.ui.bookdetailscreen;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.data.model.api.BookProfile;
import k15hkii.se114.bookstore.data.model.api.BookProfileImage;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

public class BookDetailPageViewModel extends BaseViewModel<BookDetailPageNavigator> implements Observable {

    private final MutableLiveData<List<Comment>> commentItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new Comment("tritran@gm.com"),
                          new Comment("tritran12@gm.com"))
    );
    public List<Comment> getCommentItems() {
        return commentItemsLiveData.getValue();
    }

    @Inject protected ModelRemote remote;

    private String bookProfileId;

    private BookProfile profile;
    private BookProfileImage image;

    public void setBookProfileId(String id) {
        this.bookProfileId = id;

        remote.getBookprofile(id).doOnSuccess(bookProfile -> {
            profile = bookProfile;
        }).subscribe();
        //TODO: lay data image
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
