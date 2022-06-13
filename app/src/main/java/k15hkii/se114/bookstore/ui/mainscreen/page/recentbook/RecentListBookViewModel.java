package k15hkii.se114.bookstore.ui.mainscreen.page.recentbook;

import android.util.Log;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.navigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

public class RecentListBookViewModel extends BaseViewModel<RecentListBookNavigator> {

    public final ObservableField<List<BookViewModel>> items = new ObservableField<>();

    @Inject
    protected ViewModelMapper mapper;
    private final UUID userId;

    public void getData() {
        dispose(mapper.getRecentBooks(userId),
                items::set,
                throwable -> Log.d("FavoritePageViewModel", "getData: " + throwable.getMessage(), throwable));
    }

    public RecentListBookViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.mapper = mapper;
        this.userId = preferencesHelper.getCurrentUserId();
        getData();
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

}
