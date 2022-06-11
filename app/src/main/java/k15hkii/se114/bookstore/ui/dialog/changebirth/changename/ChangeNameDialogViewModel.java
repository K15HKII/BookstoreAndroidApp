package k15hkii.se114.bookstore.ui.dialog.changebirth.changename;

import android.util.Log;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.UUID;

public class ChangeNameDialogViewModel extends BaseViewModel<ChangeNameCallBack> {

    @Inject
    protected ModelRemote remote;
    private User user;
    private UUID user_id;

    public final ObservableField<String> userName = new ObservableField<>();

    public void getData(UUID user_id){
        getCompositeDisposable().add(remote.getUser(user_id)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(user -> {
                    this.user = user;
                    this.userName.set(user.getFirstName() + " " + user.getLastName());
                    this.notifyChange();
                }, throwable -> {
                    Log.d("ChangeNameViewModel", "getSelfUser: " + throwable.getMessage(), throwable);
                }));
    }

    public ChangeNameDialogViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.remote = remote;
        this.user_id=preferencesHelper.getCurrentUserId();
        getData(user_id);
    }

    public void onSubmitClick(){
        getNavigator().dismissDialog();
    }
}
