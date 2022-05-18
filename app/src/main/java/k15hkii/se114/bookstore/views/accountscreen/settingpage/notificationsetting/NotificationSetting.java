package k15hkii.se114.bookstore.views.accountscreen.settingpage.notificationsetting;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.R;

public class NotificationSetting extends Fragment {

    private NotificationSettingViewModel mViewModel;

    public static NotificationSetting newInstance() {
        return new NotificationSetting();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.notification_setting_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NotificationSettingViewModel.class);
        // TODO: Use the ViewModel
    }

}
