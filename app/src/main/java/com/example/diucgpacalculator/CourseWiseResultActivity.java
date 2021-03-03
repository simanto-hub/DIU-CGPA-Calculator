package com.example.diucgpacalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class CourseWiseResultActivity extends AppCompatActivity {

    RecyclerView recyclerView_course_semester;
    TextView courseCGPA;

    ArrayList<CoursesSerializable> courseWiseResultArrayList = new ArrayList<>();
    public static final String CCGPA = "CCGPA";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_wise_result);

        recyclerView_course_semester = (RecyclerView) findViewById(R.id.recyclerView_course);
        courseCGPA = (TextView) findViewById(R.id.course_wise_cgpaTV);


        Intent i = getIntent();
        courseCGPA.setText(i.getStringExtra(CCGPA));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView_course_semester.setLayoutManager(layoutManager);

        courseWiseResultArrayList = (ArrayList<CoursesSerializable>) getIntent().getExtras().getSerializable("courselist");
        recyclerView_course_semester.setAdapter(new CourseWiseSgpaAdapter(courseWiseResultArrayList));
    }
}