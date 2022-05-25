package k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.foryoubooks;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

public class ForYouBooksViewModel extends BaseViewModel<ForYouBooksNavigator> implements Observable {

    private final MutableLiveData<List<BookViewModel>> ForYouBooksItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new BookViewModel("Sách Dark Nhân Tâm"),
                          new BookViewModel("Sách Kong Nghệ"),
                          new BookViewModel("Dank Nghiệp"),
                          new BookViewModel("Giải tick AKA Giải thích"))
    );

    private String userId;
    @Inject protected ModelRemote remote;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<BookViewModel> getForYouBooksItems() {
        return ForYouBooksItemsLiveData.getValue();
    }
    public ForYouBooksViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
