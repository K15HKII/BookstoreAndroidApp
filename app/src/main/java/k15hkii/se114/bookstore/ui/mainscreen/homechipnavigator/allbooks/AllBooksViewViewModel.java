package k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.allbooks;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.data.model.api.BookProfile;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class AllBooksViewViewModel extends BaseViewModel<AllBooksPageNavigator> implements Observable {

    public final ObservableField<List<BookViewModel>> items = new ObservableField<>();

    protected ModelRemote remote;

    public void getData() {
        remote.getBookprofiles()
                .observeOn(getSchedulerProvider().ui())
                .subscribe(profiles -> {
                    List<BookViewModel> list = new ArrayList<>();
                    for (BookProfile profile : profiles) {
                        BookViewModel model = new BookViewModel();
                        model.setBookProfile(profile);
                        list.add(model);
                    }
                    items.set(list);
                });
    }

    public AllBooksViewViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
        getData();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
