package k15hkii.se114.bookstore.ui.book.search;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.navigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchBookViewViewModel extends BaseViewModel<SearchBookViewNavigator> {

    public final ObservableField<List<BookViewModel>> searchResult = new ObservableField<>();

    public final ObservableField<String> searchString = new ObservableField<>();

    private final ModelRemote remote;
    private final ViewModelMapper mapper;
    private final Disposable searchObservable;

    public SearchBookViewViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, ViewModelMapper mapper) {
        super(schedulerProvider);
        this.remote = remote;
        this.mapper = mapper;

        PublishSubject<String> search = PublishSubject.create();
        searchString.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                String searchString = SearchBookViewViewModel.this.searchString.get();
                search.onNext(searchString == null ? "" : searchString);
            }
        });

        searchObservable = search.debounce(1, TimeUnit.SECONDS)
                .filter(s -> s != null && s.length() > 0)
                .distinctUntilChanged()
                .switchMapSingle(remote::getBooks)
                .doOnSubscribe(disposable -> increasePendingTask())
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doFinally(this::decreasePendingTask)
                .subscribe(books -> {
                    searchResult.set(mapper.toBookViewModel(books));
                }, throwable -> {
                    Log.e("SearchBookViewViewModel", "error: ", throwable);
                });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        getCompositeDisposable().add(searchObservable);
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

    public void onSubmitSearchQuerry() {
        getNavigator().openSearchViewResult();
    }

}
