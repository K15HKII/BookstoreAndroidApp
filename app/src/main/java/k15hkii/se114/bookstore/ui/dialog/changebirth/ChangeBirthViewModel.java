package k15hkii.se114.bookstore.ui.dialog.changebirth;

import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.user.ProfileUpdateRequest;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.Date;

public class ChangeBirthViewModel extends BaseViewModel<ChangeBirthCallBack> {

    @Inject
    protected ModelRemote remote;

    public final ObservableField<Date> userBirth = new ObservableField<>();
    User user;

    public void getData() {
        dispose(remote.getSelfUser(),
                user -> {
                    this.user = user;
                    userBirth.set(user.getBirthday());
                },
                throwable -> {
                });
    }

    public ChangeBirthViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper helper) {
        super(schedulerProvider);
        this.remote = remote;
        getData();
    }

    public void onSubmitBirthText() {
        if (userBirth.get() != user.getBirthday()) {
            ProfileUpdateRequest request = new ProfileUpdateRequest();
            request.setBirthday(userBirth.get());

            dispose(remote.updateSelfUser(request),
                    user -> {
                        getNavigator().dismissDialog();
                    },
                    throwable -> {
                    });
        }
    }

}

