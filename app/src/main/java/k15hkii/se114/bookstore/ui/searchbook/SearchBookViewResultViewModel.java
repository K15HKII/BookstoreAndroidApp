package k15hkii.se114.bookstore.ui.searchbook;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class SearchBookViewResultViewModel extends BaseViewModel<SearchBookViewResultNavigator> implements Observable {

    public final ObservableField<List<BookViewModel>> listSearch = new ObservableField<>();

    protected ViewModelRemote remote;

    public void getData() {
        dispose(remote.getBooks(),
                listSearch::set,
                throwable -> Log.d("SearchBooksViewModel", "getData: " + throwable.getMessage(), throwable));
    }

    public SearchBookViewResultViewModel(SchedulerProvider schedulerProvide, ViewModelRemote remote) {
        super(schedulerProvide);
        this.remote = remote;
        getData();
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

}
