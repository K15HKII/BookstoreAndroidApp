package k15hkii.se114.bookstore.views.ratingbookscreen;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.OrderShipmentAdapter.orderitemsrecycleview.OrderView;

import java.util.Arrays;
import java.util.List;

public class RatingBooksDetailPageViewModel extends BaseViewModel<RatingBooksDetailPageNavigator> implements Observable {

    private final MutableLiveData<List<RatingReport>> ratingBookDetailItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new RatingReport("Dac nhan tam"))
    );

    public List<RatingReport> getRatingBookDetailItems() {
        return ratingBookDetailItemsLiveData.getValue();
    }

    public RatingBooksDetailPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
