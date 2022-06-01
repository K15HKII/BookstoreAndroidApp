package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview;

import androidx.databinding.Bindable;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.model.api.Image;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;

@Getter
@Setter
public class RentBookItemViewModel extends BaseViewModel<RentBookItemNavigator> {

    private String bookProfileId;

    @Inject
    protected ModelRemote remote;

    private Book profile;
    private Image[] images;

    public void setBookProfileId(String bookProfileId) {
        this.bookProfileId = bookProfileId;

        remote.getBook(bookProfileId).doOnSuccess(profile -> {
            this.profile = profile;
        }).subscribe();

        // Todo: lay book profile image
    }

    @Bindable
    @Getter @Setter private String Name;

    public RentBookItemViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public RentBookItemViewModel(String name) {
        super(null);
        Name = name;
    }

    public void openDetail(String bookProfileId) {getNavigator().bookDetailNavigator(bookProfileId); }

}
