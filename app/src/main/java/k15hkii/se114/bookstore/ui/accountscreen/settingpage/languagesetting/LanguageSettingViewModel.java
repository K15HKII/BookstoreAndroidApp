package k15hkii.se114.bookstore.ui.accountscreen.settingpage.languagesetting;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

public class LanguageSettingViewModel extends BaseViewModel<LanguageSettingNavigator> implements Observable {
    public LanguageSettingViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    //TODO: Add function language for VIETNAMESE AND ENGLISH

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
    // TODO: Implement the ViewModel
}
