package k15hkii.se114.bookstore.ui.searchbook;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import java.util.Arrays;
import java.util.List;

public class SearchBookViewViewModel extends BaseViewModel<SearchBookViewNavigator> implements Observable {

    private final MutableLiveData<List<RecentSearchViewModel>> searchBookViewItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new RecentSearchViewModel("Dac nhan tam"),
                          new RecentSearchViewModel("hi hi"))
    );

    public List<RecentSearchViewModel> getSearchBookViewItems() {
        return searchBookViewItemsLiveData.getValue();
    }

    public SearchBookViewViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    public void onSubmitSearchQuerry(){
        getNavigator().openSearchViewResult();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
