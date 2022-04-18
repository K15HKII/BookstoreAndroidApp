package com.example.libraryapp.BankScreen.BankExpandableListView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.example.libraryapp.R;

import java.util.List;
import java.util.Map;

public class ExpandableBankAdapter extends BaseExpandableListAdapter {

    private List<BankGroup> lsBankGroup;
    private Map<BankGroup, List<BankItems>> lsBankItem;

    public ExpandableBankAdapter(List<BankGroup> lsBankGroup, Map<BankGroup, List<BankItems>> lsBankItem) {
        this.lsBankGroup = lsBankGroup;
        this.lsBankItem = lsBankItem;
    }

    @Override
    public int getGroupCount() {
        if( lsBankGroup != null ){
            return lsBankGroup.size();
        }
        return 0;
    }

    @Override
    public int getChildrenCount(int i) {
        if( lsBankGroup != null && lsBankItem != null ){
            return lsBankItem.get(lsBankGroup.get(i)).size();
        }
        return 0;
    }

    @Override
    public Object getGroup(int i) {
        return lsBankGroup.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return lsBankItem.get(lsBankGroup.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        BankGroup bankGroup = lsBankGroup.get(i);
        return bankGroup.get_id();
    }

    @Override
    public long getChildId(int i, int i1) {
        BankItems bankItems = lsBankItem.get(lsBankGroup.get(i)).get(i1);
        return bankItems.get_id();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bank_group_adapter, viewGroup, false);
        }
        TextView tvBankGroup = view.findViewById(R.id.tvAddBankBankGroup);
        BankGroup bankGroup = lsBankGroup.get(i);
        tvBankGroup.setText(bankGroup.get_BankGroupName());

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bank_item_adapter, viewGroup, false);
        }
        TextView tvBankItem = view.findViewById(R.id.tvAddBankBankItems);
        BankItems bankItems = lsBankItem.get(lsBankGroup.get(i)).get(i1);
        tvBankItem.setText(bankItems.getBankName());

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
