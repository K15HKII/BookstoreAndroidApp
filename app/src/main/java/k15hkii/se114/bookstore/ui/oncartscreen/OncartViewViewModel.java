package k15hkii.se114.bookstore.ui.oncartscreen;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import java.util.Arrays;
import java.util.List;

public class OncartViewViewModel extends BaseViewModel<OncartViewPageNavigator> implements Observable {

    private final MutableLiveData<List<OncartItemViewModel>> onCartViewItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new OncartItemViewModel("Sách Đắc Nhân Tâm"),
                          new OncartItemViewModel("Sách Công Nghệ"))
    );

    public List<OncartItemViewModel> getOnCartViewItems() {
        return onCartViewItemsLiveData.getValue();
    }

    public OncartViewViewModel(SchedulerProvider schedulerProvider) {
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
