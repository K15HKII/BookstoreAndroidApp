package k15hkii.se114.bookstore.ui.dialog.filtersearch;

import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class FilterSearchViewModel extends BaseViewModel<FilterSearchCallBack> {

    // TODO: filter, chưa làm gì hết
    public FilterSearchViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void dismissDialog() {
        getNavigator().dismissDialog();
    }

    public void openSearchViewResultClick() {
        getNavigator().openSearchResult();
    }

}
