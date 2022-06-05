package k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.familiarbooks;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelRemote;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

public class FamiliarBooksViewModel extends BaseViewModel<FamiliarBooksPageNavigator> implements Observable {

    public final ObservableField<List<BookViewModel>> items = new ObservableField<>();

    protected ViewModelRemote remote;

    public void getData() {
        dispose(remote.getBooks(),
                items::set,
                throwable -> Log.d("FamiliarBooksViewModel", "getData: " + throwable.getMessage(), throwable));
    }

    public FamiliarBooksViewModel(SchedulerProvider schedulerProvider, ViewModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
        getData();
    }

}
