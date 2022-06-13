package k15hkii.se114.bookstore.ui.mainscreen.navigator.foryou;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.navigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

public class ForYouBooksViewModel extends BaseViewModel<ForYouBooksNavigator> implements Observable {

    public final ObservableField<List<BookViewModel>> items = new ObservableField<>();

    @Inject
    protected ViewModelMapper mapper;
    private final UUID userId;

    public void getData() {
        dispose(mapper.getRecentBooks(userId),
                items::set,
                throwable -> Log.d("ForYouBooksViewModel", "getData: " + throwable.getMessage(), throwable));
    }

    public ForYouBooksViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.mapper = mapper;
        this.userId = preferencesHelper.getCurrentUserId();
        getData();
    }

}
