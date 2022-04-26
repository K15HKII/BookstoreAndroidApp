package com.example.libraryapp;

import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import com.example.libraryapp.loginscreen.Login;
import com.example.libraryapp.mainscreen.HomeLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import lombok.Getter;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("fuck huy", hashCode() + "");
        nav(Login.class);
    }

    public void nav(Class<? extends Fragment> clazz) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.clearBackStack("test");
        Log.i("asdasd", fragmentManager.hashCode() + "");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, clazz,null).addToBackStack("test").commit();
    }

}
