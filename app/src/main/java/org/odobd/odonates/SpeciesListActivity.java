package org.odobd.odonates;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.odobd.odonates.model.Species;

public class SpeciesListActivity extends AppCompatActivity {

    DatabaseReference mDatabase;

    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_species_list);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("speciesdata");

        mRecyclerView = (RecyclerView) findViewById(R.id.species_reclycler);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Species, SpeciesViewHolder> adapter =
                new FirebaseRecyclerAdapter<Species, SpeciesViewHolder>(
                        Species.class,
                        android.R.layout.two_line_list_item,
                        SpeciesViewHolder.class,
                        mDatabase) {
                    @Override
                    protected void populateViewHolder(SpeciesViewHolder viewHolder, Species model, int position) {
                        viewHolder.mText.setText(new StringBuilder().append(model.getGenus()).append(" ").append(model.getSpecificname()).toString());
                    }
                };

        mRecyclerView.setAdapter(adapter);
    }

    public static class SpeciesViewHolder
            extends RecyclerView.ViewHolder {
        TextView mText;

        public SpeciesViewHolder(View v) {
            super(v);
            mText = (TextView) v.findViewById(android.R.id.text1);
        }
    }
}
