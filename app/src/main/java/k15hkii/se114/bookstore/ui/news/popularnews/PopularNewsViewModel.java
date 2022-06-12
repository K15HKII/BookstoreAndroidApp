package k15hkii.se114.bookstore.ui.news.popularnews;

import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class PopularNewsViewModel extends BaseViewModel<PopularNewsNavigator> {
    public PopularNewsViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }
}
