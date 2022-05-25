package k15hkii.se114.bookstore.ui.intro.cityspinneradapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import k15hkii.se114.bookstore.R;

import java.util.List;

public class CitySpinnerAdapter extends BaseAdapter {

    public CitySpinnerAdapter(Context context, List<String> lsCity) {
        this.context = context;
        this.lsCity = lsCity;
    }

    private Context context;
    private List<String> lsCity;

    @Override
    public int getCount() {
        return lsCity != null ? lsCity.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.city_spinner_adapter,viewGroup,false);

        TextView tvCity = rootView.findViewById(R.id.tvCitySpinnerCityName);
        tvCity.setText(lsCity.get(i));
        return rootView;
    }
}
