package k15hkii.se114.bookstore.ui.news;

import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class NewsViewModel extends BaseViewModel<NewsNavigator> {

    public NewsViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }
}
