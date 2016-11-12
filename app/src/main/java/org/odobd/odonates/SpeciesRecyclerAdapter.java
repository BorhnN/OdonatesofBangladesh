package org.odobd.odonates;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import org.odobd.odonates.model.Species;

import java.util.ArrayList;

/**
 * Created by borhan on 11/11/16.
 */

public class SpeciesRecyclerAdapter extends RecyclerView.Adapter<SpeciesRecyclerAdapter.SpeciesViewHolder> {

    private DatabaseReference mSpeciesref;
    private Context mContext;
    private ArrayList<Species> mSpeciesList;

    public SpeciesRecyclerAdapter(Context context, ArrayList<Species> speciesArrayList) {
        mSpeciesList = speciesArrayList;
    }

    public DatabaseReference getmSpeciesref() {
        return mSpeciesref;
    }

    public Context getmContext() {
        return mContext;
    }

    public ArrayList<Species> getmSpeciesList() {
        return mSpeciesList;
    }

    @Override
    public SpeciesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(
                        R.layout.species_view,
                        parent,
                        false);
        return new SpeciesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SpeciesViewHolder holder, int position) {
        holder.mSpeciesName.setText(new StringBuilder().append(mSpeciesList.get(position).getGenus()).append(" ").append(mSpeciesList.get(position).getSpecificname()).toString());
        holder.mFamilyName.setText(mSpeciesList.get(position).getFamily());
        holder.mIUCNstatus.setText("IUCN" + ": " + mSpeciesList.get(position).getIUCN_status());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class SpeciesViewHolder extends RecyclerView.ViewHolder {
        TextView mSpeciesName;
        TextView mFamilyName;
        TextView mIUCNstatus;

        public SpeciesViewHolder(View itemView) {
            super(itemView);
            mSpeciesName = (TextView) itemView.findViewById(R.id.species_name_view);
            mFamilyName = (TextView) itemView.findViewById(R.id.family_text);
            mIUCNstatus = (TextView) itemView.findViewById(R.id.iucn_status);
        }
    }
}
