package com.example.diucgpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class SemesterWiseActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout layoutList;
    Button buttonAdd, buttonSubmitList;

    int count = 0;

    List<String> semester_numbers = new ArrayList<>();
    ArrayList<SemestersSerializable> semestersSerializableList = new ArrayList<>();
    private double totalCreditResult;
    private String round_cgpa;

    private String creditNumber;
    private String sgpaNumber;
    private double gpaMulCredit;
    private String resultListTitle= "Semester Wise SPGA and Credit List:";
    private String courseSemesterHadingName= "Semester Number";
    private String grade= "SGPA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester);

        layoutList = (LinearLayout) findViewById(R.id.layout_list);
        buttonAdd = (Button) findViewById(R.id.button_add);
        buttonSubmitList = (Button) findViewById(R.id.button_submit_list);


        buttonAdd.setOnClickListener(this);
        buttonSubmitList.setOnClickListener(this);

        semester_numbers.add("Select Semester");
        semester_numbers.add("Semester 1");
        semester_numbers.add("Semester 2");
        semester_numbers.add("Semester 3");
        semester_numbers.add("Semester 4");
        semester_numbers.add("Semester 5");
        semester_numbers.add("Semester 6");
        semester_numbers.add("Semester 7");
        semester_numbers.add("Semester 8");
        semester_numbers.add("Semester 9");
        semester_numbers.add("Semester 10");
        semester_numbers.add("Semester 11");
        semester_numbers.add("Semester 12");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_add:
                    addView();
                break;

            case R.id.button_submit_list:

                if (checkIfVaidAndRead()) {

                    Intent intent = new Intent(SemesterWiseActivity.this,SemesterWiseResult.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("list", semestersSerializableList);
                    intent.putExtra(SemesterWiseResult.SCGPA, round_cgpa);
                    intent.putExtra(SemesterWiseResult.RESULT_LIST_TITLE, resultListTitle);
                    intent.putExtra(SemesterWiseResult.COURSE_SEMESTER_HADING_NAME, courseSemesterHadingName);
                    intent.putExtra(SemesterWiseResult.GRADE, grade);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }

                break;
        }
    }

    private boolean checkIfVaidAndRead() {
        semestersSerializableList.clear();
        boolean result = true;

        for (int i = 0; i < layoutList.getChildCount(); i++) {

            View semester_wise_result = layoutList.getChildAt(i);

            Spinner semester_number = (Spinner) semester_wise_result.findViewById(R.id.semester_number);
            EditText credit = (EditText) semester_wise_result.findViewById(R.id.credit);
            EditText sgpa = (EditText) semester_wise_result.findViewById(R.id.sgpa);

            SemestersSerializable semestersSerializable = new SemestersSerializable();

            if (semester_number.getSelectedItemPosition() != 0) {
                semestersSerializable.setSemesterName(semester_numbers.get(semester_number.getSelectedItemPosition()));
            } else {
                result = false;
                break;
            }

            if (!credit.getText().toString().equals("")) {
                creditNumber = credit.getText().toString();
                semestersSerializable.setCredit(creditNumber);

            } else {
                result = false;
                break;
            }

            if (!sgpa.getText().toString().equals("")) {
                sgpaNumber = sgpa.getText().toString();
                semestersSerializable.setSgpa(sgpaNumber);
            } else {
                result = false;
                break;
            }

            gpaMulCredit += (Double.parseDouble(sgpaNumber)*Double.parseDouble(creditNumber));
            totalCreditResult += Double.parseDouble(creditNumber);

            semestersSerializableList.add(semestersSerializable);
        }

        double cgpa = gpaMulCredit/totalCreditResult;
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        round_cgpa = String.valueOf(df.format(cgpa));

        if(semestersSerializableList.size() == 0){
            result = false;
            Toast.makeText(this, "Select Semester and Add Credit and SGPA ", Toast.LENGTH_SHORT).show();
        }else if(!result){
            Toast.makeText(this, "Enter All Details Correctly", Toast.LENGTH_SHORT).show();
        }

        return result;
    }

    private void addView() {
        count++;
        if (count <= 12) {

            semester_numbers.add("Select Semester");
            semester_numbers.add("Semester 1");
            semester_numbers.add("Semester 2");
            semester_numbers.add("Semester 3");
            semester_numbers.add("Semester 4");
            semester_numbers.add("Semester 5");
            semester_numbers.add("Semester 6");
            semester_numbers.add("Semester 7");
            semester_numbers.add("Semester 8");
            semester_numbers.add("Semester 9");
            semester_numbers.add("Semester 10");
            semester_numbers.add("Semester 11");
            semester_numbers.add("Semester 12");

            View semester_wise_result = getLayoutInflater().inflate(R.layout.activity_add_semester_wise_result, null, false);

            Spinner semester_number = (Spinner) semester_wise_result.findViewById(R.id.semester_number);
            EditText credit = (EditText) semester_wise_result.findViewById(R.id.credit);
            EditText sgpa = (EditText) semester_wise_result.findViewById(R.id.sgpa);
            Button close = (Button) semester_wise_result.findViewById(R.id.close);

            ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, semester_numbers);
            semester_number.setAdapter(arrayAdapter);

            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeView(semester_wise_result);
                    Toast.makeText(getApplicationContext(), "Successfully Deleted", Toast.LENGTH_SHORT).show();
                }
            });

            layoutList.addView(semester_wise_result);
        }else {
            Toast.makeText(this, "You cannot take more than 12 Semester. If you want more please go to Course Wise CGPA CALCULATION", Toast.LENGTH_SHORT).show();

        }
    }

        private void removeView (View v){

            layoutList.removeView(v);

        }
}