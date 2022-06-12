package k15hkii.se114.bookstore.ui.searchbook;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import java.util.Arrays;
import java.util.List;

public class SearchBookViewViewModel extends BaseViewModel<SearchBookViewNavigator> implements Observable {

    private final ObservableField<List<RecentSearchViewModel>> searchBookViewItemsLiveData = new ObservableField<>();

    public ObservableField<String> etSearchBookText = new ObservableField<>();

    public List<RecentSearchViewModel> getSearchBookViewItems() {
        return searchBookViewItemsLiveData.get();
    }

    public SearchBookViewViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

    public void onSubmitSearchQuerry() {
        getNavigator().openSearchViewResult();
    }

}
