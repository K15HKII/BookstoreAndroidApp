package k15hkii.se114.bookstore.ui.accountscreen.settingpage.privacysetting;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

public class PrivacySettingViewModel extends BaseViewModel<PrivacySettingNavigator> implements Observable {

    public PrivacySettingViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void CameraPermission(){

    }

    public void ImagePermission(){

    }

    public void GPSPermission(){

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
