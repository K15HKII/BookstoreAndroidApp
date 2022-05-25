package k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator;

import k15hkii.se114.bookstore.data.model.api.BookProfile;
import k15hkii.se114.bookstore.data.model.api.BookProfileImage;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;

public class BookViewModel extends BaseViewModel<BookViewNavigator> {

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

    public BookViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    @Getter @Setter private String name;

    public BookViewModel(String name) {
        super(null);
        this.name = name;
    }

    public void openDetail() {
        getNavigator().bookDetailNavigate(bookProfileId);
    }

}
