package k15hkii.se114.bookstore.ui.mainscreen.navigator;

import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.mainscreen.BaseBookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import java.util.UUID;

public class BookViewModel extends BaseBookViewModel<BookViewNavigator> {

    public BookViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, UUID userId) {
        super(schedulerProvider, remote, userId);
    }

}
