package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview;

import android.util.Log;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.Book;
import k15hkii.se114.bookstore.data.model.api.Lend;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//@AllArgsConstructor
@Getter
@Setter
public class RentViewViewModel extends BaseViewModel<RentViewNavigator> implements Observable {

    public final ObservableField<String> bookName = new ObservableField<>();
    public final ObservableField<String> bookType = new ObservableField<>();
    public final ObservableField<String> bookPrice = new ObservableField<>();
    public final ObservableField<String> rentNote = new ObservableField<>();
    public final ObservableField<String> rentPrice = new ObservableField<>();

    @Inject protected ModelRemote remote;
    public double price = 0;
    private Lend lend;
    public void setLend(Lend lend){
        this.lend=lend;
    }
    @Bindable
    public String getPrice() {
        return lend.getBook() == null ? "null" : "đ" + String.valueOf(lend.getBook().getPrice());
    }

    public RentViewViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
    }

    public RentViewViewModel() { super(null); }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
}
