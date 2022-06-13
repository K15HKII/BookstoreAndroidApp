package k15hkii.se114.bookstore.ui.mainscreen.navigator.familiar;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.navigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import java.util.List;
import java.util.UUID;

public class FamiliarBooksViewModel extends BaseViewModel<FamiliarBooksPageNavigator> implements Observable {

    public final ObservableField<List<BookViewModel>> items = new ObservableField<>();

    protected ViewModelMapper mapper;

    public void getData(UUID userId) {
        dispose(mapper.getRecentBooks(userId),
                items::set,
                throwable -> Log.d("FamiliarBooksViewModel", "getData: " + throwable.getMessage(), throwable));
    }

    public FamiliarBooksViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper helper) {
        super(schedulerProvider);
        this.mapper = mapper;
        getData(helper.getCurrentUserId());
    }

}
