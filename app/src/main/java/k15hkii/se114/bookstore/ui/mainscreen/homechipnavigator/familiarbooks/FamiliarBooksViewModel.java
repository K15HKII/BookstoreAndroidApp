package k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.familiarbooks;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

public class FamiliarBooksViewModel extends BaseViewModel<FamiliarBooksPageNavigator> implements Observable {

    public final ObservableField<List<BookViewModel>> items = new ObservableField<>();

    protected ModelRemote remote;
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
                                               items.set(list);
                                           }, throwable -> {
                                               Log.d("FamiliarBooksViewModel", "getData: " + throwable.getMessage(), throwable);
                                           }));
    }

    public FamiliarBooksViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
        getData();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
