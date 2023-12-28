package net.braniumacademy.exercises1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryAdapter extends BaseAdapter {
    private final Context context;
    private List<Country> countries;
    private final LayoutInflater inflater;

    public CountryAdapter(Context context, List<Country> countries) {
        this.context = context;
        this.countries = countries;
        inflater = LayoutInflater.from(context);
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public Object getItem(int i) {
        return countries.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int index, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = inflater.inflate(R.layout.item_country, null);
            holder = new ViewHolder();
            holder.imageFlag = view.findViewById(R.id.image_flag);
            holder.textCapital = view.findViewById(R.id.text_capital);
            holder.textCountry = view.findViewById(R.id.text_name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Country country = countries.get(index);
        holder.imageFlag.setImageDrawable(Utils.getDrawable(context, country.getFlag()));
        holder.textCountry.setText(country.getName());
        holder.textCapital.setText(country.getCapital());
        return view;
    }

    static class ViewHolder {
        ImageView imageFlag;
        TextView textCountry;
        TextView textCapital;
    }
}
