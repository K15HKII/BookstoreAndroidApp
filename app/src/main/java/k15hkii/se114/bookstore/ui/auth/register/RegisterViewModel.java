package k15hkii.se114.bookstore.ui.auth.register;

import androidx.databinding.*;
import k15hkii.se114.bookstore.data.model.api.user.Gender;
import k15hkii.se114.bookstore.data.model.auth.RegisterRequest;
import k15hkii.se114.bookstore.data.remote.Authentication;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.SpinnerWrapper;
import k15hkii.se114.bookstore.utils.StringUtils;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Setter;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Setter
public class RegisterViewModel extends BaseViewModel<RegisterNavigator> {

    public final ObservableList<SpinnerWrapper<Gender>> gender = new ObservableArrayList<>();
    public final ObservableInt genderIndex = new ObservableInt();
    public final ObservableField<String> username = new ObservableField<>();
    public final ObservableField<Date> birthday = new ObservableField<>();
    public final ObservableField<String> phone = new ObservableField<>();

    public final ObservableField<String> email = new ObservableField<>();
    public final ObservableField<String> password = new ObservableField<>();
    public final ObservableField<String> passwordConfirm = new ObservableField<>();
    public final ObservableBoolean acceptTerms = new ObservableBoolean(false);

    private final Authentication mAuthentication;

    public RegisterViewModel(SchedulerProvider schedulerProvider, Authentication mAuthentication) {
        super(schedulerProvider);
        this.mAuthentication = mAuthentication;
        gender.addAll(Arrays.asList(SpinnerWrapper.toSpinner(Gender.values())));
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

    public void register() {
        if (StringUtils.isEmpty(username.get())) {
            getNavigator().openEmptyData("Bạn chưa nhập tài khoản");
            return;
        }

        if (birthday.get() == null) {
            getNavigator().openErrorData("Ngày sinh chưa hợp lệ");
            return;
        }

        if (!StringUtils.isPhone(phone.get())) {
            getNavigator().openErrorData("Số điện thoại chưa hợp lệ");
            return;
        }

        if (StringUtils.isEmpty(email.get())) {
            getNavigator().openEmptyData("Bạn chưa nhập email");
            return;
        }

        if (!Objects.equals(passwordConfirm.get(), password.get())) {
            getNavigator().openErrorData("Mật khẩu chưa trùng khớp");
            return;
        }

        if (!acceptTerms.get()) {
            getNavigator().openErrorData("Vui lòng chấp nhận điều khoản!");
            return;
        }

        RegisterRequest request = new RegisterRequest();
        request.setBirthday(birthday.get());
        request.setEmail(email.get());
        request.setPassword(password.get());
        request.setPhone(phone.get());
        request.setUsername(username.get());
        request.setGender(gender.get(genderIndex.get()).getItem());
        dispose(mAuthentication.register(request), response -> {
            int statuscode = response.getStatus();
            if (statuscode == 201) {
                getNavigator().openCreateSuccess("Đăng ký thành công!");
                getNavigator().openLogin();
            } else if (statuscode == 409) {
                getNavigator().openErrorData("Tài khoản đã tồn tại!");
                return;
            }
        }, throwable -> {

        });
    }

}
