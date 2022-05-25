package k15hkii.se114.bookstore.ui.mainscreen.page.homepage;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

public class HomePageViewModel extends BaseViewModel<HomePageNavigator> implements Observable {
    public HomePageViewModel(SchedulerProvider schedulerProvider) {
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

    public void onAllBooksChip(){
        getNavigator().openAllBooksView();
    }

    public void onFamiliarBooksChip(){
        getNavigator().openFamiliarBooksView();
    }

    public void onPoppularBooksChip(){
        getNavigator().openPoppularBooksView();
    }

    public void onForYouBooksChip(){
        getNavigator().openForYouBooksView();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
