package com.terrybu.listviewpractice.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.terrybu.listviewpractice.R;

import java.util.List;

/**
 * Created by TerryBu on 7/23/15.
 */

public class MoonsAdapter extends BaseAdapter {

    private final List<String> moons;

    public MoonsAdapter(List<String> moons) {
        this.moons = moons;
    }

    @Override
    public int getCount() {
        return moons.size();
    }

    @Override
    public Object getItem(int position) {
        return moons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);

        TextView moonTextView = (TextView) convertView.findViewById(R.id.text);
        String moonName = moons.get(position);
        moonTextView.setText(moonName);

        return convertView;
    }

}
