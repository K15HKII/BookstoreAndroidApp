package k15hkii.se114.bookstore.ui.news.adapter;

import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.base.INavigator;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class NewsAdapterViewModel extends BaseViewModel<INewsAdapterNavigator> {
    public NewsAdapterViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }
}
