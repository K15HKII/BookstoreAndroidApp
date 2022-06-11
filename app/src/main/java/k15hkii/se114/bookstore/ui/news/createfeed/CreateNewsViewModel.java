package k15hkii.se114.bookstore.ui.news.createfeed;

import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class CreateNewsViewModel extends BaseViewModel<CreateNewsNavigator> {

    public CreateNewsViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }
}
