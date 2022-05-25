package k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.allbooks;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import java.util.Arrays;
import java.util.List;

public class AllBooksViewViewModel extends BaseViewModel<AllBooksPageNavigator> implements Observable {

    private final MutableLiveData<List<BookViewModel>> AllBooksItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new BookViewModel("Sách Dark Nhân Tâm"),
                    new BookViewModel("Sách Kong Nghệ"),
                    new BookViewModel("Dank Nghiệp"),
                    new BookViewModel("Giải tick AKA Giải thích"))
    );

    public List<BookViewModel> getAllBooksItems() {
        return AllBooksItemsLiveData.getValue();
    }

    public AllBooksViewViewModel(SchedulerProvider schedulerProvider) {
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
