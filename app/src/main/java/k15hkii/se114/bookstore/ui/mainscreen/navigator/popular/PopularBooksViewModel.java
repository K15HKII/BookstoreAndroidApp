package k15hkii.se114.bookstore.ui.mainscreen.navigator.popular;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.navigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import java.util.List;

public class PopularBooksViewModel extends BaseViewModel<PopularBooksPageNavigator> implements Observable {

    public final ObservableField<List<BookViewModel>> items = new ObservableField<>();

    protected ViewModelMapper mapper;

    public void getData() {
        dispose(mapper.getBooks(),
                items::set,
                throwable -> Log.d("PopularBooksViewModel", "getData: " + throwable.getMessage(), throwable));
    }

    public PopularBooksViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper) {
        super(schedulerProvider);
        this.mapper = mapper;
        getData();
    }

}
