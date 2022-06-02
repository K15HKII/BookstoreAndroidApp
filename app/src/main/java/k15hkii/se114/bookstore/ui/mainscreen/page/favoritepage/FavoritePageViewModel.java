package k15hkii.se114.bookstore.ui.mainscreen.page.favoritepage;

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
import java.util.Arrays;
import java.util.List;

public class FavoritePageViewModel extends BaseViewModel<FavoritePageNavigator> implements Observable {

    public final ObservableField<List<BookViewModel>> favouriteItems = new ObservableField<>();

    @Inject protected ModelRemote remote;
    public void getData() {
        getCompositeDisposable().add(remote.getBooks()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(books -> {
                    List<BookViewModel> list = new ArrayList<>();
                    for (Book book : books) {
                        BookViewModel model = new BookViewModel();
                        model.setBookProfile(book);
                        list.add(model);
                    }
                    favouriteItems.set(list);
                }, throwable -> {
                    Log.d("FavoriteBooksViewModel", "getData: " + throwable.getMessage(), throwable);
                }));
    }


    public FavoritePageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider);
        this.remote=remote;
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
