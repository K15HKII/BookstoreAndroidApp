package k15hkii.se114.bookstore;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import k15hkii.se114.bookstore.databinding.ActivityMainBinding;
import k15hkii.se114.bookstore.di.component.ActivityComponent;
import k15hkii.se114.bookstore.ui.auth.loginscreen.Login;
import k15hkii.se114.bookstore.ui.base.BaseActivity;


public class MainActivity extends BaseActivity<ActivityMainBinding, MainActivityViewModel> {

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nav(Login.class);
    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
    }

    public void nav(Class<? extends Fragment> clazz) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.clearBackStack("test");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, clazz, null).addToBackStack("test").commit();
    }

}
