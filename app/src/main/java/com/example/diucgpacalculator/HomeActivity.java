package com.example.diucgpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button semester_wise;
    private Button course_wise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        semester_wise = (Button) findViewById(R.id.semester_wise_button);
        course_wise = (Button) findViewById(R.id.course_wise_button);

        semester_wise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,SemesterWiseActivity.class);
                startActivity(intent);
            }
        });

        course_wise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CourseWiseActivity.class);
                startActivity(intent);
            }
        });
    }
}