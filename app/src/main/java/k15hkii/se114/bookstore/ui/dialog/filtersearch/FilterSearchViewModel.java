package k15hkii.se114.bookstore.ui.dialog.filtersearch;

import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

public class FilterSearchViewModel extends BaseViewModel<FilterSearchCallBack> {

    // TODO: filter, chưa làm gì hết
    public FilterSearchViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void dismissDialog(){
        getNavigator().dismissDialog();
    }

    public void openSearchViewResultClick(){
        getNavigator().openSearchResult();
    }

}
