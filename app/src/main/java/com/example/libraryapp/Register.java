package com.example.libraryapp;

import android.widget.*;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.libraryapp.ViewModel.RegisterViewModel;

public class Register extends Fragment implements AdapterView.OnItemSelectedListener {

    private RegisterViewModel mViewModel;
    private Button btnRegister, btnRegisterWithGoogle, btnRegisterWithFacebook;
    private EditText etUsername,etDOB,etPhoneNum,etEmail;
    private Spinner spGender;
    private TextView tvPolicy;

    public static Register newInstance() {
        return new Register();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_fragment, container, false);

//        Tìm view

        btnRegister = view.findViewById(R.id.btnRegisterRegister);
        btnRegisterWithGoogle = view.findViewById(R.id.btnRegisterRegisterWithGoogle);
        btnRegisterWithFacebook = view.findViewById(R.id.btnRegisterRegisterWithFaceBook);
        etUsername = view.findViewById(R.id.etRegisterUser);
        etDOB = view.findViewById(R.id.etRegisterDOB);
        etEmail = view.findViewById(R.id.etRegisterEmail);
        etPhoneNum = view.findViewById(R.id.etRegisterPhoneNum);
        spGender = view.findViewById(R.id.spRegisterGender);
        tvPolicy = view.findViewById(R.id.tvRegisterPolicy);

//        Button Function
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnRegisterWithGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnRegisterWithFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

//        TextView Function
        tvPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

//        Set up for combobox Gender
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Register.this.getActivity(),
                                                                            R.array.Gender_spinner,
                                                                            android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spGender.setAdapter(adapter);
        spGender.setOnItemSelectedListener(Register.this);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
        // TODO: Use the ViewModel
    }

//    Thiết lập combobox selected item
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
//        Toast.makeText(adapterView.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}