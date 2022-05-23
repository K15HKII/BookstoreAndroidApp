package k15hkii.se114.bookstore.views.mainscreen.page.favoritepage;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;
import k15hkii.se114.bookstore.views.mainscreen.HomeScreen.homechipnavigation.BookView;
import k15hkii.se114.bookstore.views.mainscreen.page.shippingpage.ShippingPageNavigator;

import java.util.Arrays;
import java.util.List;

public class FavoritePageViewModel extends BaseViewModel<FavoritePageNavigator> implements Observable {

    private final MutableLiveData<List<BookView>> favouriteItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new BookView("Sách Dark Nhân Tâm"),
                    new BookView("Sách Kong Nghệ"),
                    new BookView("Dank Nghiệp"),
                    new BookView("Giải tick AKA Giải thích"))
    );

    public List<BookView> getFavouriteItems() {
        return favouriteItemsLiveData.getValue();
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
