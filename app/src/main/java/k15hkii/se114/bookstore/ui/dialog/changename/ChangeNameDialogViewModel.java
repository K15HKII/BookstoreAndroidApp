package k15hkii.se114.bookstore.ui.dialog.changename;

import android.util.Log;
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

    @Inject
    protected ModelRemote remote;

    PreferencesHelper preferencesHelper;

    public final ObservableField<String> newName = new ObservableField<>();
    public final ObservableField<String> firstName = new ObservableField<>();
    public final ObservableField<String> lastName = new ObservableField<>();

    private User user;

    public void getData(UUID userId) {
        dispose(remote.getUser(userId), user -> {
            this.user = user;
            newName.set(user.getFirstName() + " " + user.getLastName());
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
        if(newName.get().isEmpty()){
            getNavigator().openMissingNameDialog("Cần nhập tên mới");
            return;
        }
        if (!Objects.equals(newName.get(), (user.getFirstName() + " " + user.getLastName()))) {
            ProfileUpdateRequest request = new ProfileUpdateRequest();
            request.setFirstname(newName.get());
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
