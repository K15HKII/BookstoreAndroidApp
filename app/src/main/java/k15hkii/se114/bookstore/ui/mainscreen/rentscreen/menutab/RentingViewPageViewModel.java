package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class RentingViewPageViewModel extends BaseViewModel<RentingViewPageNavigator> implements Observable {

    public final ObservableField<List<BookViewModel>> rentList = new ObservableField<>();

    @Inject protected ModelRemote remote;
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
                    rentList.set(list);
                }, throwable -> {
                    Log.d("FavoriteBooksViewModel", "getData: " + throwable.getMessage(), throwable);
                }));
    }

    public RentingViewPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
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
}
