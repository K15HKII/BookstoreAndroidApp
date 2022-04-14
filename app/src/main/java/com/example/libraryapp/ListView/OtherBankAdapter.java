package com.example.libraryapp.ListView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.libraryapp.R;

import java.util.List;

public class OtherBankAdapter extends BaseAdapter {

    List<String> lsBank;
    Activity activity;

    public OtherBankAdapter(List<String> lsBank, Activity activity) {
        this.lsBank = lsBank;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return lsBank.size();
    }

    @Override
    public Object getItem(int i) {
        return lsBank.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.bank_choice_adapter,null);
        TextView tvBankName = view.findViewById(R.id.tvBankChoiceAdapterBankName);
        tvBankName.setText(lsBank.get(i));
        return view;
    }
}
