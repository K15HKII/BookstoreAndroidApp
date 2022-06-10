package k15hkii.se114.bookstore.ui.accountscreen.helppage.helpcenter;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

public class HelpCenterViewModel extends BaseViewModel<HelpCenterNavigator> implements Observable {
    public HelpCenterViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public ObservableField<String> email = new ObservableField<>();
    public ObservableField<String> phone = new ObservableField<>();

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

}
