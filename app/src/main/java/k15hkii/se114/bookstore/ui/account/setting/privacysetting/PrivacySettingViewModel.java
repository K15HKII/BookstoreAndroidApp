package k15hkii.se114.bookstore.ui.account.setting.privacysetting;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class PrivacySettingViewModel extends BaseViewModel<PrivacySettingNavigator> implements Observable {

    public PrivacySettingViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void CameraPermission() {

    }

    public void ImagePermission() {

    }

    public void GPSPermission() {

    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

}
