package com.izampa.assignment.three;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.izampa.assignment.three.adapter.CustomAdapter;
import com.izampa.assignment.three.model.Student;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    SecondFragment secondFragment;
    ArrayList<Student> dummyData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        FloatingActionButton fab = view.findViewById(R.id.fab);
        recyclerView = view.findViewById(R.id.recycler_view);

        // get Second Fragment
        secondFragment = new SecondFragment();

        dummyData = new ArrayList<>();
        if (secondFragment.allData == null) {
            customAdapter = new CustomAdapter(dummyData);
        } else {
            customAdapter = new CustomAdapter(secondFragment.allData);
        }
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (getArguments() != null) {
            secondFragment.allData = getArguments().getParcelableArrayList("allData");
            Log.d("DEBUG", "onResume: " + secondFragment.allData);
        }


        fab.setOnClickListener(v -> {
            FragmentManager fragmentManager = this.getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container_view, secondFragment).addToBackStack("tag");
            fragmentTransaction.commit();
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Create an adapter
        if (secondFragment.allData == null) {
            customAdapter = new CustomAdapter(dummyData);
        } else {
            assert getArguments() != null;
            customAdapter = new CustomAdapter(getArguments().getParcelableArrayList("allData"));
        }
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }
}