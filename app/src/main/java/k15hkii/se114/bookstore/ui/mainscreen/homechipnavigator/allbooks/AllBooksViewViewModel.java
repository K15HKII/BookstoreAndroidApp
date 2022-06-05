package k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.allbooks;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class AllBooksViewViewModel extends BaseViewModel<AllBooksPageNavigator> implements Observable {

    public final ObservableField<List<BookViewModel>> items = new ObservableField<>();

    protected ViewModelRemote remote;

    public AllBooksViewViewModel(SchedulerProvider schedulerProvider, ViewModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
        getData();
    }

    public void getData() {
        dispose(remote.getBooks(),
                items::set,
                throwable -> Log.d("AllBooksViewViewModel", "getData: " + throwable.getMessage(), throwable));
    }

}
