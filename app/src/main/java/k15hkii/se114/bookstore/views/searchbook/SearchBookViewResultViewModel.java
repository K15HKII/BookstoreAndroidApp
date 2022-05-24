package k15hkii.se114.bookstore.views.searchbook;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;
import k15hkii.se114.bookstore.views.mainscreen.homechipnavigator.BookView;

import java.util.Arrays;
import java.util.List;

public class SearchBookViewResultViewModel extends BaseViewModel<SearchBookViewResultNavigator> implements Observable {

    private final MutableLiveData<List<BookView>> searchBookItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new BookView("Sách Dark Nhân Tâm"),
                          new BookView("Sách Kong Nghệ"),
                          new BookView("Dank Nghiệp"),
                          new BookView("Giải tick AKA Giải thích"))
    );

    public List<BookView> getSearchBookViewItems() {
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
