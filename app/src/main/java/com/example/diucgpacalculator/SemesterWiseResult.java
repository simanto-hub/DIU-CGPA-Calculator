package com.example.diucgpacalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SemesterWiseResult extends AppCompatActivity {

    RecyclerView recyclerView_semester;
    TextView semesterCGPA;
    TextView resultListTitle;
    TextView courseSemesterHadingName;
    TextView grade;

    ArrayList<SemestersSerializable> semesterWiseResultArrayList = new ArrayList<>();
    public static final String SCGPA = "SCGPA";
    public static final String RESULT_LIST_TITLE = "RESULT_LIST_TITLE";
    public static final String COURSE_SEMESTER_HADING_NAME = "COURSE_SEMESTER_HADING_NAME";
    public static final String GRADE = "GRADE";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_recyclerview);

        recyclerView_semester = (RecyclerView) findViewById(R.id.recyclerView_semester);
        semesterCGPA = (TextView) findViewById(R.id.semester_cgpaTV);
        resultListTitle = (TextView) findViewById(R.id.resultListTitleTV);
        courseSemesterHadingName = (TextView) findViewById(R.id.courseSemester_hading_nameBtn);
        grade = (TextView) findViewById(R.id.gradeTV);

        Intent i = getIntent();
        semesterCGPA.setText(i.getStringExtra(SCGPA));
        resultListTitle.setText(i.getStringExtra(RESULT_LIST_TITLE));
        courseSemesterHadingName.setText(i.getStringExtra(COURSE_SEMESTER_HADING_NAME));
        grade.setText(i.getStringExtra(GRADE));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView_semester.setLayoutManager(layoutManager);

            semesterWiseResultArrayList = (ArrayList<SemestersSerializable>) getIntent().getExtras().getSerializable("list");
            recyclerView_semester.setAdapter(new SemesterWiseSgpaAdapter(semesterWiseResultArrayList));


    }
}
