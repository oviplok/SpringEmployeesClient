package com.example.springemployeesclient.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.springemployeesclient.EmployeeListActivity;
import com.example.springemployeesclient.R;
import com.example.springemployeesclient.model.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeHolder> {
    private List<Employee> employeeList;

    public EmployeeAdapter(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_employee_item,parent,false);
        return new EmployeeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder holder, int position) {
        Employee employee = this.employeeList.get(position);
        //Log.v("KAL: ",employee.getFio().toString());

        holder.name.setText(employee.getFio());
        holder.location.setText(employee.getLocation());
        holder.branch.setText(employee.getBranch());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }
}
