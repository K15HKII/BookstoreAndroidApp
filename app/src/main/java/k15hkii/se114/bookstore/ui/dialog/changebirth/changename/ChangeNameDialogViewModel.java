package k15hkii.se114.bookstore.ui.dialog.changebirth.changename;

import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.user.ProfileUpdateRequest;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.Objects;
import java.util.UUID;

public class ChangeNameDialogViewModel extends BaseViewModel<ChangeNameCallBack> {

    @Inject protected ModelRemote remote;

    PreferencesHelper preferencesHelper;

    public final ObservableField<String> newName = new ObservableField<>();

    String oldName;
    User user;

    public void getData(UUID userId) {
        remote.getUser(userId).doOnSuccess(user -> {
            this.user = user;
            newName.set(user.getFirstName() + " " + user.getLastName());
        }).subscribe();
    }

    public ChangeNameDialogViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.preferencesHelper = preferencesHelper;
        this.remote = remote;
        getData(preferencesHelper.getCurrentUserId());
    }

    public void onSubmitClick(){
        if (!Objects.equals(newName.get(), (user.getFirstName() + " " + user.getLastName()))) {
            ProfileUpdateRequest request = new ProfileUpdateRequest();
            request.setFirstname(newName.get());

            dispose(remote.updateSelfUser(request),
                    user -> {},
                    throwable -> {});
        }
        getNavigator().dismissDialog();
    }
}
