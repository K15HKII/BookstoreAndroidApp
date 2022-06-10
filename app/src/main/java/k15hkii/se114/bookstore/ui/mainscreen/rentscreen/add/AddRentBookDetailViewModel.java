package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.add;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

public class AddRentBookDetailViewModel extends BaseViewModel<AddRentBookDetailNavigator> implements Observable {
    public AddRentBookDetailViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public ObservableField<String> etBookName = new ObservableField<>();
    public ObservableField<String> etDescription = new ObservableField<>();

    public final ObservableField<String> bookName = new ObservableField<>();
    public final ObservableField<String> rentPrice = new ObservableField<>();
    public final ObservableField<String> bookDescription = new ObservableField<>();

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    public void openAddRentInfo(){
        getNavigator().openAddRentInfo();
    }

}
