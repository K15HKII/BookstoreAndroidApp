package k15hkii.se114.bookstore.ui.mainscreen.page.favoritepage;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

public class FavoritePageViewModel extends BaseViewModel<FavoritePageNavigator> implements Observable {

    public final ObservableList<BookViewModel> items = new ObservableArrayList<>();

    @Inject protected ViewModelMapper mapper;
    private UUID userId;

    public void getData() {
        dispose(mapper.getFavouriteBooks(userId),
                items::addAll,
                throwable -> Log.d("FavoritePageViewModel", "getData: " + throwable.getMessage(), throwable));
    }

    public FavoritePageViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.mapper = mapper;
        this.userId = preferencesHelper.getCurrentUserId();
        getData();
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

}
