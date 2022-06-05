package k15hkii.se114.bookstore.ui.searchbook;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
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

    @Inject  protected ModelRemote remote;

    public void getData() {
        getCompositeDisposable().add(remote.getBooks()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(books -> {
                    List<BookViewModel> list = new ArrayList<>();
                    for (Book book : books) {
                        BookViewModel model = new BookViewModel();
                        model.setBook(book);
                        list.add(model);
                    }
                    listSearch.set(list);
                }, throwable -> {
                    Log.d("SearchBooksViewModel", "getData: " + throwable.getMessage(), throwable);
                }));
    }

    public SearchBookViewResultViewModel(SchedulerProvider schedulerProvide, ModelRemote remote) {
        super(schedulerProvide);
        this.remote = remote;
        getData();
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
