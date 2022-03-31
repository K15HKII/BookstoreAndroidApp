package com.example.libraryapp;

import android.widget.Button;
import android.widget.EditText;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Register extends Fragment {

    private RegisterViewModel mViewModel;
    private Button btn_Register;
    private EditText et_Username,et_Gender,et_DOB,et_PhoneNum,et_Email;

    public static Register newInstance() {
        return new Register();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_fragment, container, false);

//        Tìm view
        btn_Register = view.findViewById(R.id.btn_Register_Register);
        et_Username = view.findViewById(R.id.et_Register_User);
        et_DOB = view.findViewById(R.id.et_Register_DOB);
        et_Gender = view.findViewById(R.id.et_Register_Gender);
        et_Email = view.findViewById(R.id.et_Register_Email);
        et_PhoneNum = view.findViewById(R.id.et_Register_PhoneNum);

        return inflater.inflate(R.layout.register_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
        // TODO: Use the ViewModel
    }

}