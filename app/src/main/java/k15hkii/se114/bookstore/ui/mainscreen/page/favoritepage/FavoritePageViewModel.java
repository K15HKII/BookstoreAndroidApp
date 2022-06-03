package k15hkii.se114.bookstore.ui.mainscreen.page.favoritepage;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FavoritePageViewModel extends BaseViewModel<FavoritePageNavigator> implements Observable {

    public final ObservableField<List<BookViewModel>> favouriteItems = new ObservableField<>();

    @Inject protected ModelRemote remote;
    private UUID userId;
    public void getData(UUID user_id) {
        getCompositeDisposable().add(remote.getFavoriteBooks(user_id)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(books -> {
                    List<BookViewModel> list = new ArrayList<>();
                    for (Book book : books) {
                        BookViewModel model = new BookViewModel();
                        model.setBook(book);
                        list.add(model);
                    }
                    favouriteItems.set(list);
                }, throwable -> {
                    Log.d("FavoriteBooksViewModel", "getData: " + throwable.getMessage(), throwable);
                }));
    }


    public FavoritePageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.remote=remote;
        this.userId = preferencesHelper.getCurrentUserId();
        getData(userId);
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
