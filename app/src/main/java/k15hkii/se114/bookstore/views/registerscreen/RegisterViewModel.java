package k15hkii.se114.bookstore.views.registerscreen;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.lifecycle.ViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;
import lombok.Getter;
import lombok.Setter;

@Setter
public class RegisterViewModel extends BaseViewModel<RegisterNavigator> implements Observable {

    private String user, gender, dob, phonenum, email, pass, passconfirm;

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

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
