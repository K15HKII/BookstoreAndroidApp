package k15hkii.se114.bookstore.ui.accountscreen;

import android.util.Log;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.user.Gender;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.model.api.user.UserAddress;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.base.INavigator;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

public class BaseUserInfoViewModel<N extends INavigator> extends BaseViewModel<N> {

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<Gender> gender = new ObservableField<>();
    public final ObservableField<Date> birthday = new ObservableField<>();
    public final ObservableField<String> phone = new ObservableField<>();
    public final ObservableField<String> email = new ObservableField<>();
    public final ObservableField<UserAddress> address = new ObservableField<>();
    public final ObservableField<String> username = new ObservableField<>();

    private final ModelRemote remote;

    @Getter private final UUID userId;
    @Getter private User user;

    public BaseUserInfoViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, UUID userId) {
        super(schedulerProvider);
        this.remote = remote;
        this.userId = userId;

        from(userId);
    }

    public void from(UUID userId) {
        getCompositeDisposable().add(remote.getSelfUser()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(user -> {
                    this.user = user;
                    this.name.set(user.getName());
                    this.username.set(user.getUsername());
                    this.email.set(user.getEmail());
                    this.gender.set(user.getGender());
                    this.phone.set(user.getPhone());
                    this.birthday.set(user.getBirthday());
                }, throwable -> {
                    Log.d(getClass().getSimpleName(), "getSelfUser: " + throwable.getMessage(), throwable);
                }));
    }

}