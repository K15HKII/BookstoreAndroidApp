package k15hkii.se114.bookstore.ui.ratingbookscreen;

import android.net.Uri;
import android.util.Log;
import androidx.databinding.ObservableDouble;
import androidx.databinding.ObservableField;
import io.reactivex.Observable;
import k15hkii.se114.bookstore.data.model.api.file.File;
import k15hkii.se114.bookstore.data.model.api.message.FeedbackCRUDRequest;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.utils.RemoteUtils;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class RateDetailViewModel extends BaseViewModel<RatingBooksDetailPageNavigator> {

    protected ViewModelMapper mapper;
    private final ModelRemote remote;

    private final UUID userId;

    public final ObservableField<String> comment = new ObservableField<>();
    public final ObservableField<List<Uri>> imageUris = new ObservableField<>(new LinkedList<>());
    public final ObservableField<List<Uri>> videoUris = new ObservableField<>(new LinkedList<>());
    public final ObservableDouble rating = new ObservableDouble();

    public RateDetailViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, ModelRemote remote, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.mapper = mapper;
        this.remote = remote;
        this.userId = preferencesHelper.getCurrentUserId();
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

    public void selectImages(Uri... uris) {
        imageUris.get().addAll(Arrays.asList(uris));
    }

    public void selectVideos(Uri... uris) {
        videoUris.get().addAll(Arrays.asList(uris));
    }

    public void postFeedback() {
        dispose(Observable.fromIterable(imageUris.get())
                        .flatMapSingle(uri -> remote.uploadImage(RemoteUtils.from(uri)))
                        .map(File::getId)
                        .toList(),
                images -> {
                    Log.d("RateDetailViewModel", "ConfirmRating: " + images.size());
                    FeedbackCRUDRequest request = new FeedbackCRUDRequest(images, null, comment.get(), userId, rating.get());
                    dispose(remote.sendFeedback(request), feedback -> {
                       //TODO: handle feedback
                    }, throwable -> {
                        Log.d("RateDetailViewModel", "ConfirmRating: " + throwable.getMessage());
                    });
                },
                throwable -> Log.d("RateDetailViewModel", "ConfirmRating: " + throwable.getMessage(), throwable));
    }

}
