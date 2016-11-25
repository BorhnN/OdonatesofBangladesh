package org.odobd.odonates;

import android.content.Context;
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
        holder.mFamilyName.setText(mAllSpecies.get(position).getFamily());
        holder.mSpeciesName.setText(mAllSpecies.get(position).getSpecificname());
    }

    @Override
    public int getItemCount() {
        return mAllSpecies.size();
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
