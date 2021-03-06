package k15hkii.se114.bookstore.ui.book.detail;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.data.model.api.message.Feedback;
import k15hkii.se114.bookstore.data.model.api.user.RecentBookCRUDRequest;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.mainscreen.BaseBookViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookDetailPageViewModel extends BaseBookViewModel<BookDetailPageNavigator> {

    public final ObservableField<List<FeedbackViewModel>> feedbacks = new ObservableField<>();

    public BookDetailPageViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, UUID userId) {
        super(schedulerProvider, remote, userId);
    }

    public final ObservableField<String> description = new ObservableField<>();
    public final ObservableInt remainQuantity = new ObservableInt();

    public void setBook(Book book) {
        super.setBook(book);

        RecentBookCRUDRequest request = new RecentBookCRUDRequest();
        request.setBookId(book.getId());
        dispose(getRemote().createRecentBook(getUserId(), request), b -> {

        }, throwable -> {
            Log.e("BookDetailPageViewModel", "createRecentBook error", throwable);
        });
        description.set(book.getDescription());
        remainQuantity.set(book.getStock());
        dispose(getRemote().getFeedbacks(book.getId())
                        .map(feedbacks -> {
                            List<FeedbackViewModel> list = new ArrayList<>();
                            for (Feedback feedback : feedbacks) {
                                FeedbackViewModel vm = new FeedbackViewModel(getSchedulerProvider(), getRemote());
                                vm.setFeedback(feedback);
                                list.add(vm);
                            }
                            return list;
                        }),
                this.feedbacks::set,
                error -> {
                    Log.d("", "Error: " + error.getMessage());
                });
    }

    @Override
    public void initializeFromBundle(@NonNull @NotNull Bundle bundle) {
        super.initializeFromBundle(bundle);
        Book book = (Book) bundle.getSerializable("book");
        if (book != null) setBook(book);
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

    public void openBuyNowDialog() {
        if (remainQuantity.get() > 0) {
            getNavigator().openBuyNowDialog(getBook());
        } else {
            getNavigator().openSoldOutDialog();
            return;
        }
    }

    public void openOnCartDialog() {
        if (remainQuantity.get() > 0) {
            getNavigator().openOnCartDialog(getBook());
        } else {
            getNavigator().openSoldOutDialog();
            return;
        }
    }

}
