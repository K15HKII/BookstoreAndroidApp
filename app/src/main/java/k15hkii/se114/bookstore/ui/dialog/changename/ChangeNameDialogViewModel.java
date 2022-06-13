package k15hkii.se114.bookstore.ui.dialog.changename;

import android.util.Log;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.user.ProfileUpdateRequest;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.Objects;
import java.util.UUID;

public class ChangeNameDialogViewModel extends BaseViewModel<ChangeNameCallBack> {

    @Inject
    protected ModelRemote remote;

    PreferencesHelper preferencesHelper;

    public final ObservableField<String> firstName = new ObservableField<>();
    public final ObservableField<String> lastName = new ObservableField<>();

    private User user;

    public void getData(UUID userId) {
        dispose(remote.getUser(userId), user -> {
            this.user = user;
            firstName.set(user.getFirstName());
            lastName.set(user.getLastName());
        }, throwable -> {
            Log.d("ChangeNameDialog", "getData: " + throwable.getMessage());
        });
    }

    public ChangeNameDialogViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.preferencesHelper = preferencesHelper;
        this.remote = remote;
        getData(preferencesHelper.getCurrentUserId());
    }

    public void onSubmitClick() {
        if (firstName.get() == null || firstName.get().isEmpty() || lastName.get() == null || lastName.get().isEmpty()) {
            getNavigator().openMissingNameDialog("Cần nhập tên mới");
            return;
        }
        if (!Objects.equals(firstName.get(), user.getFirstName()) || !Objects.equals(lastName.get(), user.getLastName())) {
            ProfileUpdateRequest request = new ProfileUpdateRequest();
            request.setFirstname(firstName.get());
            request.setLastname(lastName.get());
            dispose(remote.updateSelfUser(request),
                    user -> {
                        getNavigator().dismissDialog();
                    },
                    throwable -> {
                        getNavigator().openInvalidNameDialog("Tên đã tồn tại");
                    });
        }

    }

}
