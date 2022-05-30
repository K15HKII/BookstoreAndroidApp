package k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import k15hkii.se114.bookstore.data.model.api.BookProfile;
import k15hkii.se114.bookstore.data.model.api.BookProfileImage;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;

public class BookViewModel extends BaseViewModel<BookViewNavigator> implements Observable {

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

    public void setBookProfile(BookProfile profile) {
        this.profile = profile;
    }

    public BookViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    @Bindable
    public String getName() {
        return profile == null ? "profile is null" : profile.getName();
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
