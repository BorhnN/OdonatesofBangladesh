package org.odobd.odonates;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class SpeciesListActivity extends AppCompatActivity {

    DatabaseReference mDatabase;
    RecyclerView mRecyclerView;
    SpeciesRecyclerAdapter mSpeciesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_species_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.species_reclycler);
        mSpeciesAdapter = new SpeciesRecyclerAdapter(this);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setAdapter(mSpeciesAdapter);


    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public static class SpeciesViewHolder
            extends RecyclerView.ViewHolder {
        TextView mSpeciesName;
        TextView mFamilyName;
        TextView mIUCNstatus;

        public SpeciesViewHolder(View v) {
            super(v);
            mSpeciesName = (TextView) v.findViewById(R.id.species_name_view);
            mFamilyName = (TextView) v.findViewById(R.id.common_name);
            mIUCNstatus = (TextView) v.findViewById(R.id.iucn_status);
        }
    }
}
