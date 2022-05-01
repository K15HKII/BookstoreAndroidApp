package k15hkii.se114.bookstore.views;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import k15hkii.se114.bookstore.R;

import java.util.List;

public class OtherAddressAdapter extends BaseAdapter {

    List<String> lsAddresses;
    Activity activity;

    public OtherAddressAdapter(List<String> lsAddresses,  Activity activity) {
        this.lsAddresses = lsAddresses;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return lsAddresses.size();
    }

    @Override
    public Object getItem(int i) {
        return lsAddresses.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.selector_address_adapter,null);
        TextView tvAddress = view.findViewById(R.id.btnAddressChoiceOtherAddress);
        tvAddress.setText(lsAddresses.get(i));
        return view;
    }
}