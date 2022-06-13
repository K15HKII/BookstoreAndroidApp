package k15hkii.se114.bookstore.ui.dialog.changephone;

import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.user.ProfileUpdateRequest;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.StringUtils;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.Objects;

public class ChangePhoneNumViewModel extends BaseViewModel<ChangePhoneNumCallBack> {

    @Inject
    protected ModelRemote remote;

    PreferencesHelper helper;

    public final ObservableField<String> userPhone = new ObservableField<>();

    User user;

    public void getData() {
        dispose(remote.getSelfUser(),
                user -> {
                    this.user = user;
                    userPhone.set(user.getPhone());
                },
                throwable -> {
                });
    }

    public ChangePhoneNumViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper helper) {
        super(schedulerProvider);
        this.helper = helper;
        this.remote = remote;
        getData();
    }

    public void onSubmitPhoneTextClick() {
        if (userPhone.get() == null || userPhone.get().isEmpty()) {
            getNavigator().openMissingPhoneDialog("Cần nhập số điện thoại mới");
            return;
        } else if (!StringUtils.isPhone(userPhone.get())) {
            getNavigator().openInvalidPhoneDialog("Số điện thoại không hợp lệ");
            return;
        }

        if (!Objects.equals(userPhone.get(), user.getPhone())) {
            ProfileUpdateRequest request = new ProfileUpdateRequest();
            request.setPhone(userPhone.get());

            dispose(remote.updateSelfUser(request),
                    user -> {
                        getNavigator().dismissDialog();
                    },
                    throwable -> {
                    });
        }

    }

}
