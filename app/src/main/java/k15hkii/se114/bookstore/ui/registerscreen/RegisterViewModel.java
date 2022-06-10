package k15hkii.se114.bookstore.ui.registerscreen;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.lifecycle.MutableLiveData;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Setter
public class RegisterViewModel extends BaseViewModel<RegisterNavigator> implements Observable {

    private String user, gender, dob, phonenum, email, pass, passconfirm;
    @Getter private final MutableLiveData<List<String>> testSource = new MutableLiveData<>(Arrays.asList("Nam", "Nữ", "Khác"));

    @Bindable
    public String getUser() {
        return user;
    }

    @Bindable
    public String getGender() {
        return gender;
    }

    @Bindable
    public String getDob() {
        return dob;
    }

    @Bindable
    public String getPhonenum() {
        return phonenum;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    @Bindable
    public String getPass() {
        return pass;
    }

    @Bindable
    public String getPassconfirm() {
        return passconfirm;
    }

    public RegisterViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

}
