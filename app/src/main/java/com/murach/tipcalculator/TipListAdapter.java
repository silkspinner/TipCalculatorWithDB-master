package com.murach.tipcalculator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by jugld on 5/15/2018.
 */

public class TipListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Tip> tips;

    public TipListAdapter(Context context, ArrayList<Tip> tips) {
        this.context = context;
        this.tips = tips;
    }

    @Override
    public int getCount() {
        return tips.size();
    }

    @Override
    public Object getItem(int position) {
        return tips.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TipLayout tipLayout = null;
        Tip tip = tips.get(position);

        if(convertView == null) {
            tipLayout = new TipLayout(context, tip);
            tipLayout = (TipLayout) convertView;
            tipLayout.setTip(tip);
        }

        return tipLayout;
    }
}
