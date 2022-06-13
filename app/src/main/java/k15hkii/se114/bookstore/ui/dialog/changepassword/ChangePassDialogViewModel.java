package k15hkii.se114.bookstore.ui.dialog.changepassword;

import android.util.Log;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.Objects;
import java.util.UUID;

public class ChangePassDialogViewModel extends BaseViewModel<ChangePassCallBack> {

    //TODO: Change Password

    @Inject
    protected ModelRemote remote;

    PreferencesHelper preferencesHelper;

    private User user;

    public final ObservableField<String> oldpassWord = new ObservableField<>();
    public final ObservableField<String> newPassWord = new ObservableField<>();
    public final ObservableField<String> ConfirmPassWord = new ObservableField<>();

    public void getData(UUID userId) {
        dispose(remote.getUser(userId), user -> {
            this.user = user;
        }, throwable -> {
            Log.d("ChangePasswordDialog", "getData: " + throwable.getMessage());
        });
    }

    public ChangePassDialogViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper helper) {
        super(schedulerProvider);
        this.preferencesHelper = helper;
        this.remote = remote;
        getData(preferencesHelper.getCurrentUserId());
    }

    public void onSubmitPass() {
        if (oldpassWord.get().isEmpty() || newPassWord.get().isEmpty() || ConfirmPassWord.get().isEmpty()) {
            getNavigator().openMissingDataDialog("Cần nhập mật khẩu cũ");
            return;
        } else if (!oldpassWord.get().equals(user.getPassword())) {
            getNavigator().openInvalidPasswordDialog("Mật khẩu cũ không đúng");
            return;
        } else if (!Objects.equals(newPassWord.get(), ConfirmPassWord.get())) {
            getNavigator().openInvalidPasswordDialog("Mật khẩu mới không trùng khớp");
            return;
        }
    }

}
