package k15hkii.se114.bookstore.views.mainscreen.page.favoritepage;

import androidx.databinding.Observable;
import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;
import k15hkii.se114.bookstore.views.mainscreen.page.shippingpage.ShippingPageNavigator;

public class FavoritePageViewModel extends BaseViewModel<FavoritePageNavigator> implements Observable {
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
