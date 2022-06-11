package k15hkii.se114.bookstore.ui.dialog.changegender;

import android.util.Log;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.UUID;

public class ChangeGenderViewModel extends BaseViewModel<ChangeGenderDialogCallBack> {

    @Inject
    protected ModelRemote remote;
    private User user;
    private UUID user_id;

    public final ObservableField<String> userGender = new ObservableField<>();

    public void getData(UUID user_id){
        getCompositeDisposable().add(remote.getUser(user_id)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(user -> {
                    this.user = user;
                    this.userGender.set(String.valueOf(user.getGender()));
                    this.notifyChange();
                }, throwable -> {
                    Log.d("ChangeGenderViewModel", "getSelfUser: " + throwable.getMessage(), throwable);
                }));
    }

    public ChangeGenderViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper helper) {
        super(schedulerProvider);
        this.remote = remote;
        this.user_id = helper.getCurrentUserId();
        getData(user_id);
    }

    public void onSubmitGenderText(){
        getNavigator().onSubmitGender();
    }
}
