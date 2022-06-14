package k15hkii.se114.bookstore.ui.dialog.changeemail;

import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.user.ProfileUpdateRequest;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;

public class ChangeEmailViewModel extends BaseViewModel<ChangeEmailCallBack> {

    @Inject
    protected ModelRemote remote;

    public final ObservableField<String> userEmail = new ObservableField<>();
    User user;

    public void getData() {
        dispose(remote.getSelfUser(),
                user -> {
                    this.user = user;
                    userEmail.set(user.getEmail());
                },
                throwable -> {
                });
    }

    public ChangeEmailViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper helper) {
        super(schedulerProvider);
        this.remote = remote;
        getData();
    }

    public void onSubmitEmailText() {
        if (userEmail.get().isEmpty()) {
            getNavigator().openMissingEmailDialog("Cần nhập email mới");
            return;
        }
        if (userEmail.get() != user.getEmail()) {
            ProfileUpdateRequest request = new ProfileUpdateRequest();
            request.setEmail(userEmail.get());

            dispose(remote.updateSelfUser(request),
                    user -> {
                        getNavigator().dismissDialog();
                    },
                    throwable -> {
                        getNavigator().openInvalidEmailDialog("Email đã tồn tại");
                    });
        }

    }

}
