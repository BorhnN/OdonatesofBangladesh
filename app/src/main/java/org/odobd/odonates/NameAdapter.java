package org.odobd.odonates;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by borhan on 11/18/16.
 */

public class NameAdapter extends BaseAdapter {

    final ArrayList<String> mNames = new ArrayList<String>();
    private Context mContext;
    private Random mRandom = new Random();

    public NameAdapter(Context context) {
        mContext = context;
        for (int i = 0; i < 5; i++) {
            mNames.add(getRandomName());
        }
    }

    @Override
    public int getCount() {
        return mNames.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.species_view, parent, false);
        }

        return null;
    }

    private String getRandomName() {
        String[] names = new String[]{
                "fajeso", "faefea", "dfjiepaskedf", "fjoawef", "foawejfa", "dfkcoaewfk"
        };
        return names[mRandom.nextInt(names.length)];
    }
}
