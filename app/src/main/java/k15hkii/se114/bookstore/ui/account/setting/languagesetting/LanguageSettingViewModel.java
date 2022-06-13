package k15hkii.se114.bookstore.ui.account.setting.languagesetting;

import androidx.databinding.Observable;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class LanguageSettingViewModel extends BaseViewModel<LanguageSettingNavigator> implements Observable {

    public LanguageSettingViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

    //TODO: Add function language for VIETNAMESE AND ENGLISH
}
