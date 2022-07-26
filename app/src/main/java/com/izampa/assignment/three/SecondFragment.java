package com.izampa.assignment.three;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.izampa.assignment.three.model.Student;

import java.util.ArrayList;

public class SecondFragment extends Fragment implements View.OnClickListener {

    EditText firstName;
    EditText lastName;
    EditText middleName;
    EditText email;
    EditText program;
    EditText yearOfStudy;
    EditText numberOfItems;
    TextView numberOfRecords;
    TextView letsRecordTitle;
    Button recordButton;
    Button proceedButton;
    FirstFragment firstFragment;
    ArrayList<Student> allData;
    int howMany;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        firstName = view.findViewById(R.id.first_name);
        lastName = view.findViewById(R.id.last_name);
        middleName = view.findViewById(R.id.middle_name);
        email = view.findViewById(R.id.student_email);
        program = view.findViewById(R.id.student_program);
        yearOfStudy = view.findViewById(R.id.student_year_of_study);
        numberOfItems = view.findViewById(R.id.number_of_items);
        numberOfRecords = view.findViewById(R.id.number_of_records);
        letsRecordTitle = view.findViewById(R.id.record_title);
        recordButton = view.findViewById(R.id.record_btn);
        proceedButton = view.findViewById(R.id.proceed);

        firstFragment = new FirstFragment();
        allData = new ArrayList<>();

        proceedButton.setOnClickListener(v -> {
            howMany = Integer.parseInt(numberOfItems.getText().toString());
            hideLayout(view);
        });

        recordButton.setOnClickListener(this);

        return view;
    }

    ArrayList<Student> addData(Editable firstName,
                               Editable lastName,
                               Editable email,
                               Editable program, Editable yearOfStudy) {

        ArrayList<Student> studentArrayList = new ArrayList<>();

        // add the data to the arrayList
        studentArrayList.add(new Student(email.toString(),
                firstName.toString(),
                lastName.toString(), program.toString(), 219L, 4L));

        Toast.makeText(getActivity(), "Data recorded successfully!", Toast.LENGTH_LONG).show();


        return studentArrayList;
    }

    @Override
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        FirstFragment firstFragment = new FirstFragment();
        int i;

        // find a way to send multiple items at the recyclerView
        //
        for (i = 0; i < 2; i++) {
            allData.addAll(addData(firstName.getText(),
                    lastName.getText(),
                    email.getText(),
                    program.getText(),
                    yearOfStudy.getText()));
        }

        bundle.putParcelableArrayList("allData", allData);
        firstFragment.setArguments(bundle);

        // Clear EditText(s)
        clearEditText();

        // Navigate back
        FragmentManager fragmentManager = this.getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_view, firstFragment);
        fragmentTransaction.commit();

    }

    void hideLayout(View view) {
        // hide
        numberOfRecords.setVisibility(View.GONE);
        numberOfItems.setVisibility(View.GONE);
        proceedButton.setVisibility(View.GONE);

        // show
        firstName.setVisibility(View.VISIBLE);
        lastName.setVisibility(View.VISIBLE);
        middleName.setVisibility(View.VISIBLE);
        email.setVisibility(View.VISIBLE);
        program.setVisibility(View.VISIBLE);
        yearOfStudy.setVisibility(View.VISIBLE);
        recordButton.setVisibility(View.VISIBLE);
    }

    void clearEditText() {
        firstName.setText("");
        lastName.setText("");
        middleName.setText("");
        email.setText("");
        program.setText("");
        yearOfStudy.setText("");
    }

    public void navigator(View view) {
        FragmentManager fragmentManager = this.getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_view, firstFragment);
        fragmentTransaction.commit();
    }
}