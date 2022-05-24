package k15hkii.se114.bookstore.views.searchbook;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.OrderShipmentAdapter.orderitemsrecycleview.OrderView;

import java.util.Arrays;
import java.util.List;

public class SearchBookViewViewModel extends BaseViewModel<SearchBookViewNavigator> implements Observable {

    private final MutableLiveData<List<RecentSearch>> searchBookViewItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new RecentSearch("Dac nhan tam"),
                          new RecentSearch("hi hi"))
    );

    public List<RecentSearch> getSearchBookViewItems() {
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