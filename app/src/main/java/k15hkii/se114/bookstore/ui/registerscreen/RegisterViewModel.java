package k15hkii.se114.bookstore.ui.registerscreen;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Setter
public class RegisterViewModel extends BaseViewModel<RegisterNavigator> implements Observable {

    @Getter public final ObservableField<List<String>> gender = new ObservableField<>(Arrays.asList("Nam", "Nữ", "Khác"));
    @Getter public final ObservableField<String> userName = new ObservableField<>();
    @Getter public final ObservableField<String> dob = new ObservableField<>();
    @Getter public final ObservableField<String> phoneNumber = new ObservableField<>();
    @Getter public final ObservableField<String> email = new ObservableField<>();
    @Getter public final ObservableField<String> password = new ObservableField<>();
    @Getter public final ObservableField<String> passConfirm = new ObservableField<>();

    //TODO: post

    public RegisterViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

}
