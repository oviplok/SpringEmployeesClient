package com.example.springemployeesclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.springemployeesclient.adapter.EmployeeAdapter;
import com.example.springemployeesclient.model.Employee;
import com.example.springemployeesclient.retrofit.EmployeeApi;
import com.example.springemployeesclient.retrofit.RetrofitService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeListActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        recyclerView = findViewById(R.id.employee_list_RView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        loadEmployees();

        FloatingActionButton floatingActionButton = findViewById(R.id.employee_list_fab);
        floatingActionButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, EmployeeFormActivity.class);
            startActivity(intent);
        });
    }

    private void loadEmployees() {
        RetrofitService retrofitService = new RetrofitService();
        EmployeeApi employeeApi= retrofitService.getRetrofit().create(EmployeeApi.class);
        Employee employee = new Employee();
        employeeApi.getAllEmployees().enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                populateListView(response.body());
                Toast.makeText(EmployeeListActivity.this, "Employees loaded",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Toast.makeText(EmployeeListActivity.this, "Load failure",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void populateListView(List<Employee> employeeList) {
        EmployeeAdapter employeeAdapter = new EmployeeAdapter(employeeList);
        recyclerView.setAdapter(employeeAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadEmployees();
    }
}