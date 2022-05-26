package k15hkii.se114.bookstore.ui.mainscreen.page.favoritepage;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.data.model.api.User;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

public class FavoritePageViewModel extends BaseViewModel<FavoritePageNavigator> implements Observable {

    private final MutableLiveData<List<BookViewModel>> favouriteItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new BookViewModel("Sách Dark Nhân Tâm"),
                    new BookViewModel("Sách Kong Nghệ"),
                    new BookViewModel("Dank Nghiệp"),
                    new BookViewModel("Giải tick AKA Giải thích"))
    );

    public List<BookViewModel> getFavouriteItems() {
        return favouriteItemsLiveData.getValue();
    }

    @Inject protected ModelRemote remote;

    private String userId;
    private User user;
    public void setUserId(String userId) {
        this.userId = userId;

        //
    }

    public FavoritePageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
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
