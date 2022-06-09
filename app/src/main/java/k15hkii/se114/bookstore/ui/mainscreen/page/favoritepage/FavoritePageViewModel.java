package k15hkii.se114.bookstore.ui.mainscreen.page.favoritepage;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

public class FavoritePageViewModel extends BaseViewModel<FavoritePageNavigator> implements Observable {

    public final ObservableField<List<BookViewModel>> items = new ObservableField<>();

    @Inject protected ViewModelMapper mapper;
    private UUID userId;

    public void getData() {
        dispose(mapper.getFavouriteBooks(userId),
                items::set,
                throwable -> Log.d("FavoritePageViewModel", "getData: " + throwable.getMessage(), throwable));
    }

    public FavoritePageViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.mapper = mapper;
        this.userId = preferencesHelper.getCurrentUserId();
        getData();
    }

    public void onSearchBarClick(){
        getNavigator().openSearchView();
    }

    public void onNotificationClick(){
        getNavigator().openNotificationView();
    }

    public void onOnCartClick(){
        getNavigator().openOnCartView();
    }

    public void onFilterDialog(){
        getNavigator().openFilterDialog();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
