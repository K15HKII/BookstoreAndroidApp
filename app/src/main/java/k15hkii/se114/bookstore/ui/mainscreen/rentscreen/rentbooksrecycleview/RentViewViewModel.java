package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview;

import android.util.Log;
import android.view.textclassifier.ConversationAction;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.Completable;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.model.api.Lend;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@AllArgsConstructor
@Getter
@Setter
public class RentViewViewModel extends BaseViewModel<RentViewNavigator> implements Observable {

    public final ObservableField<List<BookViewModel>> rentItems = new ObservableField<>();

    @Inject protected ModelRemote remote;
    public double price = 0;
    public void getData() {
        getCompositeDisposable().add(remote.getBooks()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(books -> {
                    List<BookViewModel> list = new ArrayList<>();
                    for (Book book : books) {
                        price += book.getPrice();
                        BookViewModel model = new BookViewModel();
                        model.setBookProfile(book);
                        list.add(model);
                    }
                    rentItems.set(list);
                }, throwable -> {
                    Log.d("RentBooksViewModel", "getData: " + throwable.getMessage(), throwable);
                }));
    }
    public String getTotalPrice(){
        return String.valueOf(price);
    }

    public RentViewViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
        getData();
    }

    public RentViewViewModel() { super(null); }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    public void openDetail() {getNavigator().rentDetailNavigator(); }
}
