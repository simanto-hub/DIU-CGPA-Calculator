package com.example.diucgpacalculator;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseWiseSgpaAdapter extends RecyclerView.Adapter<CourseWiseSgpaAdapter.CourseWiseSgpaView> {

    ArrayList<CoursesSerializable> courseWiseResultList = new ArrayList<>();

    public CourseWiseSgpaAdapter(ArrayList<CoursesSerializable> courseWiseResultList) {
        this.courseWiseResultList = courseWiseResultList;
    }



        @NonNull
    @Override
    public CourseWiseSgpaAdapter.CourseWiseSgpaView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_wise_course_result,parent,false);

        return new CourseWiseSgpaView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseWiseSgpaAdapter.CourseWiseSgpaView holder, int position) {


        CoursesSerializable semester = courseWiseResultList.get(position);
        holder.courseName.setText(semester.getCourseName());
        holder.creditNumber.setText(semester.getCourseCredit());
        holder.gpaNumber.setText(semester.getCourseGPA());


    }

    @Override
    public int getItemCount() {
        return courseWiseResultList.size();
    }

    public class CourseWiseSgpaView extends  RecyclerView.ViewHolder{

        TextView courseName, creditNumber, gpaNumber;

        public CourseWiseSgpaView(@NonNull View itemView) {
            super(itemView);

            courseName = (TextView) itemView.findViewById(R.id.course_nameTV);
            creditNumber = (TextView) itemView.findViewById(R.id.course_creditTV);
            gpaNumber = (TextView) itemView.findViewById(R.id.course_gpaTV);
        }
    }

}
