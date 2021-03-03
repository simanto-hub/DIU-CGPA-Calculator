package com.example.diucgpacalculator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SemesterWiseSgpaAdapter extends RecyclerView.Adapter<SemesterWiseSgpaAdapter.SemesterWiseSgpaView> {


    ArrayList<SemestersSerializable> semesterWiseResultList = new ArrayList<>();

    public SemesterWiseSgpaAdapter(ArrayList<SemestersSerializable> semesterWiseResultList) {
        this.semesterWiseResultList = semesterWiseResultList;
    }


    @NonNull
    @Override
    public SemesterWiseSgpaView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_wise_semester_result,parent,false);

        return new SemesterWiseSgpaView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SemesterWiseSgpaView holder, int position) {


        SemestersSerializable semester = semesterWiseResultList.get(position);
        holder.semesterNumber.setText(semester.getSemesterName());
        holder.creditNumber.setText(semester.getCredit());
        holder.sgpaNumber.setText(semester.getSgpa());


    }

    @Override
    public int getItemCount() {
        return semesterWiseResultList.size();
    }

    public class SemesterWiseSgpaView extends  RecyclerView.ViewHolder{

        TextView semesterNumber, creditNumber, sgpaNumber;

        public SemesterWiseSgpaView(@NonNull View itemView) {
            super(itemView);

            semesterNumber = (TextView) itemView.findViewById(R.id.semester_numberTV);
            creditNumber = (TextView) itemView.findViewById(R.id.creditTV);
            sgpaNumber = (TextView) itemView.findViewById(R.id.sgpaTV);
        }
    }
}
