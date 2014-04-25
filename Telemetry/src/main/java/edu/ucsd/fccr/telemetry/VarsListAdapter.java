package edu.ucsd.fccr.telemetry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by alex on 4/24/14.
 */
public class VarsListAdapter extends BaseAdapter {

    public String[] name = {"Variables", "Altitude", "Speed", "Direction", "Battery"};
    public String[] value = {"", "402.8 ft", "5 mph", "103 degrees", "83%"};
    public boolean[] editable = {false, false, false, false, false};
    String[] Title, Detail;
    boolean[] Editable;
    LayoutInflater inflater;
    Context context;

    VarsListAdapter() {
        Title = null;
        Detail = null;
    }
    public VarsListAdapter(Context context) {
        Title = name;
        Detail = value;
        Editable = editable;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }
    @Override
    public int getCount() {
        return Title.length;
    }
    @Override
    public Object getItem(int arg0) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.from(context).inflate(R.layout.list_item, parent, false);
        }
        TextView title, detail;
        ImageView editIndicator;
        title = (TextView) convertView.findViewById(R.id.varstv1);
        detail = (TextView) convertView.findViewById(R.id.varstv2);
        editIndicator = (ImageView) convertView.findViewById(R.id.editable_indicator);
        title.setText(Title[position]);
        detail.setText(Detail[position]);
        if (Editable[position])
        {
            editIndicator.setVisibility(View.VISIBLE);
        }
        else
        {
            editIndicator.setVisibility(View.INVISIBLE);
        }

        return convertView;
    }

}