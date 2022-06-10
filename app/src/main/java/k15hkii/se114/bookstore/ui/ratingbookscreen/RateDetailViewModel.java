package k15hkii.se114.bookstore.ui.ratingbookscreen;

import android.net.Uri;
import android.util.Log;
import androidx.databinding.ObservableDouble;
import androidx.databinding.ObservableField;
import io.reactivex.Observable;
import io.reactivex.Single;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.utils.RemoteUtils;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class RateDetailViewModel extends BaseViewModel<RatingBooksDetailPageNavigator> {

    protected ViewModelMapper mapper;
    private final ModelRemote remote;

    private final UUID userId;

    public final ObservableField<String> comment = new ObservableField<>();
    public final ObservableField<List<Uri>> imageUris = new ObservableField<>(new LinkedList<>());
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

    public void ConfirmRating() {
        dispose(Observable.fromArray(imageUris.get().toArray(new Uri[0]))
                        .flatMapSingle(uri -> remote.uploadImage(RemoteUtils.from(uri)))
                        .toList(),
                images -> {
                    Log.d("RateDetailViewModel", "ConfirmRating: " + images.size());
                    //TODO: send feedback to server
                },
                throwable -> Log.d("RateDetailViewModel", "ConfirmRating: " + throwable.getMessage(), throwable));
    }

}
