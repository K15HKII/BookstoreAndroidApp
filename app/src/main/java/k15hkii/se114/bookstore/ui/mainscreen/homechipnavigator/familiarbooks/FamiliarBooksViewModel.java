package k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.familiarbooks;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import java.util.List;

public class FamiliarBooksViewModel extends BaseViewModel<FamiliarBooksPageNavigator> implements Observable {

    public final ObservableField<List<BookViewModel>> items = new ObservableField<>();

    protected ViewModelMapper mapper;

    public void getData() {
        dispose(mapper.getBooks(),
                items::set,
                throwable -> Log.d("FamiliarBooksViewModel", "getData: " + throwable.getMessage(), throwable));
    }

    public FamiliarBooksViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper) {
        super(schedulerProvider);
        this.mapper = mapper;
        getData();
    }

}
