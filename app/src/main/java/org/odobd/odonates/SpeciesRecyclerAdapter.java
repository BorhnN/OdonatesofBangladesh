package org.odobd.odonates;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.odobd.odonates.model.Species;

import java.util.ArrayList;

/**
 * Created by borhan on 11/11/16.
 */

public class SpeciesRecyclerAdapter extends RecyclerView.Adapter<SpeciesRecyclerAdapter.SpeciesViewHolder> {

    private Context mContext;
    private ArrayList<Species> mAllSpecies = new ArrayList<>();

    public SpeciesRecyclerAdapter(Context context) {
        mContext = context;
        getData();
    }

    private void getData() {

        final ArrayList<Species> allSpecies = new ArrayList<>();
        DatabaseReference dataRoot = FirebaseDatabase.getInstance().getReference()
                .child("speciesdata");
        dataRoot.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    allSpecies.add(childSnapshot.getValue(Species.class));
                    Log.d("DataCreate", String.valueOf(allSpecies.size()));
                    notifyDataSetChanged();
                }
                Log.d("DataCreate", "Size outside program" + String.valueOf(allSpecies.size()));
                mAllSpecies = allSpecies;
                notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        Log.d("DataCreate", "Current Size" + String.valueOf(mAllSpecies.size()));
    }


    @Override
    public SpeciesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.species_view, parent, false);
        return new SpeciesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SpeciesViewHolder holder, int position) {
        Resources res = mContext.getResources();
        Species currentSpecies = mAllSpecies.get(position);
        holder.mCommonName.setText(currentSpecies.getCommonname());
        holder.mSpeciesName.setText(
                String.format(res.getString(R.string.scientific_name_format),
                        currentSpecies.getGenus(),
                        currentSpecies.getSpecificname()));
        holder.mIUCNstatus.setText(
                String.format(res.getString(R.string.IUCN_field_on_species_list_act),
                        currentSpecies.getIUCN_status()));
    }

    @Override
    public int getItemCount() {
        return mAllSpecies.size();
    }

    public class SpeciesViewHolder extends RecyclerView.ViewHolder {
        TextView mSpeciesName;
        TextView mCommonName;
        TextView mIUCNstatus;

        public SpeciesViewHolder(View itemView) {
            super(itemView);
            mSpeciesName = (TextView) itemView.findViewById(R.id.species_name_view);
            mCommonName = (TextView) itemView.findViewById(R.id.common_name);
            mIUCNstatus = (TextView) itemView.findViewById(R.id.iucn_status);
        }
    }
}
