package com.example.springemployeesclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.springemployeesclient.model.Employee;
import com.example.springemployeesclient.retrofit.EmployeeApi;
import com.example.springemployeesclient.retrofit.RetrofitService;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeCompoment();
    }

    private void initializeCompoment() {
        TextInputEditText emp_name = findViewById(R.id.employee_name_textfield);
        TextInputEditText emp_location = findViewById(R.id.employee_location_textfield);
        TextInputEditText emp_branch = findViewById(R.id.employee_branch_textfield);
        MaterialButton add_button = findViewById(R.id.add_employee_button);

        add_button.setOnClickListener(view -> {
            if ((emp_branch.getText().toString().isEmpty()
                    || emp_location.getText().toString().isEmpty()
                    || emp_name.getText().toString().isEmpty())){

            }
            else{
                RetrofitService retrofitService = new RetrofitService();
                EmployeeApi employeeApi= retrofitService.getRetrofit().create(EmployeeApi.class);

                String name = emp_name.getText().toString();
                String location =emp_location.getText().toString();
                String branch = emp_branch.getText().toString();

                Employee employee = new Employee();
                employee.setFio(name);
                employee.setBranch(branch);
                employee.setLocation(location);

                employeeApi.saveEmployee(employee)
                        .enqueue(new Callback<Employee>() {
                    @Override
                    public void onResponse(Call<Employee> call, Response<Employee> response) {
                        Toast.makeText(MainActivity.this, "Save Successful, "+name, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Employee> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Save Failed(((((", Toast.LENGTH_SHORT).show();
                        Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "");
                    }
                });


            }

        });

    }
}