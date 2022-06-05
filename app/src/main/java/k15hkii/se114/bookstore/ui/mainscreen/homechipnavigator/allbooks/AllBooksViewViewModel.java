package k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.allbooks;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import java.util.List;

public class AllBooksViewViewModel extends BaseViewModel<AllBooksPageNavigator> implements Observable {

    public final ObservableField<List<BookViewModel>> items = new ObservableField<>();

    protected ViewModelMapper mapper;

    public AllBooksViewViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper) {
        super(schedulerProvider);
        this.mapper = mapper;
        getData();
    }

    public void getData() {
        dispose(mapper.getBooks(),
                items::set,
                throwable -> Log.d("AllBooksViewViewModel", "getData: " + throwable.getMessage(), throwable));
    }

}
