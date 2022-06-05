package k15hkii.se114.bookstore.ui.searchbook;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;

import java.util.List;

public class SearchBookViewResultViewModel extends BaseViewModel<SearchBookViewResultNavigator> implements Observable {

    public final ObservableField<List<BookViewModel>> listSearch = new ObservableField<>();

    protected ViewModelMapper mapper;

    public void getData() {
        dispose(mapper.getBooks(),
                listSearch::set,
                throwable -> Log.d("SearchBooksViewModel", "getData: " + throwable.getMessage(), throwable));
    }

    public SearchBookViewResultViewModel(SchedulerProvider schedulerProvide, ViewModelMapper mapper) {
        super(schedulerProvide);
        this.mapper = mapper;
        getData();
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

}
