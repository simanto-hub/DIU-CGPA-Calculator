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

public class CourseWiseActivity extends AppCompatActivity implements View.OnClickListener  {

    LinearLayout layoutCourseList;
    Button coursebuttonAdd, coursebuttonSubmitList;

    ArrayList<CoursesSerializable> coursesSerializablelist = new ArrayList<>();
    private double totalCreditResult;
    private String round_course_cgpa;

    private String creditNumber;
    private String course_name;
    private String sgpaNumber;
    private double gpaMulCredit;
    private String resultListTitle= "Semester Wise SPGA and Credit List:";
    private String courseSemesterHadingName= "Semester Number";
    private String grade= "SGPA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_wise);

        layoutCourseList = (LinearLayout) findViewById(R.id.layout_course_list);
        coursebuttonAdd = (Button) findViewById(R.id.course_button_add);
        coursebuttonSubmitList = (Button) findViewById(R.id.course_button_submit_list);


        coursebuttonAdd.setOnClickListener(this);
        coursebuttonSubmitList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.course_button_add:
                addView();
                break;

            case R.id.course_button_submit_list:

                if (checkIfVaidAndRead()) {

                    Intent intent = new Intent(CourseWiseActivity.this,CourseWiseResultActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("courselist", coursesSerializablelist);
                    intent.putExtra(CourseWiseResultActivity.CCGPA, round_course_cgpa);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }

                break;
        }
    }

    private boolean checkIfVaidAndRead() {
        coursesSerializablelist.clear();
        boolean result = true;

        for (int i = 0; i < layoutCourseList.getChildCount(); i++) {

            View course_wise_result = layoutCourseList.getChildAt(i);

            EditText courseName = (EditText) course_wise_result.findViewById(R.id.course_code_or_NameET);
            EditText courseCredit = (EditText) course_wise_result.findViewById(R.id.course_credit);
            EditText courseGPA = (EditText) course_wise_result.findViewById(R.id.course_gpa);

            CoursesSerializable coursesSerializable = new CoursesSerializable();

            if (!courseName.getText().toString().equals("")) {
                course_name = courseName.getText().toString();
                coursesSerializable.setCourseName(course_name);

            } else {
                result = false;
                break;
            }


            if (!courseCredit.getText().toString().equals("")) {
                creditNumber = courseCredit.getText().toString();
                coursesSerializable.setCourseCredit(creditNumber);

            } else {
                result = false;
                break;
            }

            if (!courseGPA.getText().toString().equals("")) {
                sgpaNumber = courseGPA.getText().toString();
                coursesSerializable.setCourseGPA(sgpaNumber);
            } else {
                result = false;
                break;
            }

            gpaMulCredit += (Double.parseDouble(sgpaNumber)*Double.parseDouble(creditNumber));
            totalCreditResult += Double.parseDouble(creditNumber);

            coursesSerializablelist.add(coursesSerializable);
        }

        double cgpa = gpaMulCredit/totalCreditResult;
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        round_course_cgpa = String.valueOf(df.format(cgpa));

        if(coursesSerializablelist.size() == 0){
            result = false;
            Toast.makeText(this, "Select Semester and Add Credit and SGPA ", Toast.LENGTH_SHORT).show();
        }else if(!result){
            Toast.makeText(this, "Enter All Details Correctly", Toast.LENGTH_SHORT).show();
        }

        return result;
    }

    private void addView() {

            View course_wise_result = getLayoutInflater().inflate(R.layout.activity_add_course_wise_result, null, false);

            EditText courseName = (EditText) course_wise_result.findViewById(R.id.course_code_or_NameET);
            EditText credit = (EditText) course_wise_result.findViewById(R.id.course_credit);
            EditText sgpa = (EditText) course_wise_result.findViewById(R.id.course_gpa);
            Button close = (Button) course_wise_result.findViewById(R.id.course_close);

            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeView(course_wise_result);
                    Toast.makeText(getApplicationContext(), "Successfully Deleted", Toast.LENGTH_SHORT).show();
                }
            });

            layoutCourseList.addView(course_wise_result);

    }

    private void removeView (View v){

        layoutCourseList.removeView(v);

    }
}