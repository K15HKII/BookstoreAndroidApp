package k15hkii.se114.bookstore.views.bookdetailscreen;

import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;
import k15hkii.se114.bookstore.views.bankscreen.BankAccount;

import java.util.Arrays;
import java.util.List;

public class BookDetailPageViewModel extends BaseViewModel<BookDetailPageNavigator> implements Observable {

    private final MutableLiveData<List<Comment>> commentItemsLiveData = new MutableLiveData<>(
            Arrays.asList(new Comment("tritran@gm.com"),
                          new Comment("tritran12@gm.com"))
    );
    public List<Comment> getCommentItems() {
        return commentItemsLiveData.getValue();
    }

    public BookDetailPageViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
