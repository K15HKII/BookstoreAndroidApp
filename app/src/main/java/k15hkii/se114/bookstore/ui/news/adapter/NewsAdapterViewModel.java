package k15hkii.se114.bookstore.ui.news.adapter;

import android.util.Log;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableLong;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.data.model.api.message.Feedback;
import k15hkii.se114.bookstore.data.model.api.message.Message;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.book.detail.BaseCommentViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class NewsAdapterViewModel extends BaseCommentViewModel<INewsAdapterNavigator> {

    public final ObservableField<Image> bookImage = new ObservableField<>();
    public final ObservableField<String> bookTitle = new ObservableField<>();
    public final ObservableLong price = new ObservableLong();

    public NewsAdapterViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider, remote);
    }

    public void setMessage(Message message) {
        super.setMessage(message);
        Feedback feedback = (Feedback) message;
        dispose(getRemote().getBook(feedback.getBookId()), book -> {
            if (book.getImages() != null && book.getImages().size() > 0) {
                bookImage.set(book.getImages().get(0));
            }
            bookTitle.set(book.getTitle());
            price.set(book.getPrice());
        }, throwable -> {
            Log.d("BaseCommentViewModel", "Error get book", throwable);
        });
    }

}
