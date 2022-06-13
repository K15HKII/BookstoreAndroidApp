package k15hkii.se114.bookstore.ui.forgotpassscreen;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.StringUtils;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.Objects;
import java.util.UUID;

public class ForgotPasswordViewModel extends BaseViewModel<ForgotPassNavigator> implements Observable {

    public final ObservableField<String> email = new ObservableField<>();
    public final ObservableField<String> notification = new ObservableField<>();

    @Inject
    protected ModelRemote remote;
    private UUID userId;

    public ForgotPasswordViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
        notification.set("Nhập số điện thoại hoặc email để nhận mã xác thực");
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

    public void onSubmit() {
        if (!StringUtils.isMail(email.get())) {
            notification.set("Email không hợp lệ. Vui lòng nhập lại!");
            return;
        }
    }

    public void OpenRegister() {
        getNavigator().OpenRegister();
    }

}
