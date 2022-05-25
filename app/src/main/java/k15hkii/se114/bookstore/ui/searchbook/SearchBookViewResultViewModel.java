package k15hkii.se114.bookstore.ui.searchbook;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;

import java.util.Arrays;
import java.util.List;

public class SearchBookViewResultViewModel extends BaseViewModel<SearchBookViewResultNavigator> implements Observable {

    private final MutableLiveData<List<BookViewModel>> searchBookItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new BookViewModel("Sách Dark Nhân Tâm"),
                          new BookViewModel("Sách Kong Nghệ"),
                          new BookViewModel("Dank Nghiệp"),
                          new BookViewModel("Giải tick AKA Giải thích"))
    );

    public List<BookViewModel> getSearchBookViewItems() {
        return searchBookItemsLiveData.getValue();
    }
    public SearchBookViewResultViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
