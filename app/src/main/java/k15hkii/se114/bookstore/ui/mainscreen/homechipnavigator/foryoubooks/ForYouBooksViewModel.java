package k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.foryoubooks;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelRemote;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ForYouBooksViewModel extends BaseViewModel<ForYouBooksNavigator> implements Observable {

    public final ObservableField<List<BookViewModel>> items = new ObservableField<>();

    @Inject
    protected ViewModelRemote remote;
    private final UUID userId;

    public void getData() {
        dispose(remote.getRecentBooks(userId),
                items::set,
                throwable -> Log.d("ForYouBooksViewModel", "getData: " + throwable.getMessage(), throwable));
    }

    public ForYouBooksViewModel(SchedulerProvider schedulerProvider, ViewModelRemote remote, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.remote = remote;
        this.userId = preferencesHelper.getCurrentUserId();
        getData();
    }

}
