package com.example.libraryapp.RegisterScreen;

import android.app.DatePickerDialog;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.widget.*;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.libraryapp.R;
import com.example.libraryapp.ViewModel.RegisterViewModel;

import java.util.Calendar;

public class Register extends Fragment implements AdapterView.OnItemSelectedListener {

    private RegisterViewModel mViewModel;
    private Button btnRegister;
    private EditText etUsername,etDOB,etPhoneNum,etEmail,etPassword,etPasswordConfirm;
    private Spinner spGender;
    private TextView tvPolicy;
    private DatePickerDialog.OnDateSetListener datePickerDOB;
    private Calendar DOB;
    private boolean passwordVisible;

    public static Register newInstance() {
        return new Register();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_fragment, container, false);

//        Tìm view
        btnRegister = view.findViewById(R.id.btnRegisterRegister);
        etUsername = view.findViewById(R.id.etRegisterUser);
        etDOB = view.findViewById(R.id.etRegisterDOB);
        etEmail = view.findViewById(R.id.etRegisterEmail);
        etPhoneNum = view.findViewById(R.id.etRegisterPhoneNum);
        etPassword = view.findViewById(R.id.etRegisterPassword);
        etPasswordConfirm = view.findViewById(R.id.etRegisterPasswordConfirm);
        spGender = view.findViewById(R.id.spRegisterGender);

//      Button Function
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        etDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Utils.pickDate(getActivity(), datePickerDOB);
            }
        });

        etPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right = 2;
                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    if(motionEvent.getRawX()>=etPassword.getRight()-etPassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = etPassword.getSelectionEnd();
                        if(passwordVisible){
                            //set drawable image here
                            etPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_visibility_off_black,0);
                            //for hide password
                            etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }
                        else{
                            //set drawable image here
                            etPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_visibility_black,0);
                            //for show password
                            etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        etPassword.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        etPasswordConfirm.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right = 2;
                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    if(motionEvent.getRawX()>=etPassword.getRight()-etPassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = etPassword.getSelectionEnd();
                        if(passwordVisible){
                            //set drawable image here
                            etPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_visibility_off_black,0);
                            //for hide password
                            etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }
                        else{
                            //set drawable image here
                            etPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_visibility_black,0);
                            //for show password
                            etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        etPassword.setSelection(selection);
                        return true;
                    }
                }
                return false;
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
