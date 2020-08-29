package com.example.secondprototype;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

/*This is the code for second fragment displaying the Examples tab displaying recycler view */


public class Tab2Fragment extends Fragment {

    public static final String tag = "Tab2Fragment";
    RecyclerView recyclerView;
    MyAdapter adapter;
    Spinner spinner;
    ArrayAdapter<String> arrayAdapter;
    String[] filter = {"All","Animal","Architecture","Art","Face","Nature"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_fragment,container,false);

        spinner = (Spinner)view.findViewById(R.id.spinner);
        arrayAdapter = new ArrayAdapter<String>(container.getContext(),android.R.layout.simple_dropdown_item_1line ,filter);
        spinner.setAdapter(arrayAdapter);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<Model> options = new FirebaseRecyclerOptions.Builder<Model>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Data").child("All"),Model.class)
                .build();

        adapter = new MyAdapter(options);
        recyclerView.setAdapter(adapter);

        adapter.setListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DataSnapshot documentSnapshot, int position) {
                  Model model = documentSnapshot.getValue(Model.class);
                  String url = model.getVidURL();

                  Intent intent = new Intent(getActivity(),StartPlayer.class);
                  Log.i("URL GRN",url);
                  intent.putExtra(StartPlayer.URL_ID,url);

                  startActivity(intent);
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                changeQuery(filter[position]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    public void changeQuery(String q)
    {
        FirebaseRecyclerOptions<Model> newOptions = new FirebaseRecyclerOptions.Builder<Model>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Data").child(q),Model.class)
                .build();

        adapter.updateOptions(newOptions);
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}

