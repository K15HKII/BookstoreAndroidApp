package k15hkii.se114.bookstore.ui.dialog.changegender;

import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.user.Gender;
import k15hkii.se114.bookstore.data.model.api.user.ProfileUpdateRequest;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;

public class ChangeGenderViewModel extends BaseViewModel<ChangeGenderDialogCallBack> {

    @Inject
    protected ModelRemote remote;

    PreferencesHelper helper;

    User user;

    public final ObservableField<Gender> userGender = new ObservableField<>();

    public void getData() {
        dispose(remote.getSelfUser(),
                user -> {
                    this.user = user;
                    userGender.set(user.getGender());
                },
                throwable -> { });
    }

    public ChangeGenderViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper helper) {
        super(schedulerProvider);
        this.helper = helper;
        this.remote = remote;
    }

    public void onSubmitGenderText(){
        if (userGender.get() != user.getGender()) {
            ProfileUpdateRequest request = new ProfileUpdateRequest();
            request.setGender(userGender.get());

            dispose(remote.updateSelfUser(request),
                    user -> { },
                    throwable -> { });
        }
        getNavigator().onSubmitGender();
    }

}
