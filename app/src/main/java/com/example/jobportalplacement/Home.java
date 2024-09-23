package com.example.jobportalplacement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Home extends AppCompatActivity {
    LinearLayout jobListContainer;
    ActivityResultLauncher<Intent> addJobActivityLauncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        jobListContainer = findViewById(R.id.jobListContainer);

        addJobActivityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK && result.getData() != null){
                Intent data = result.getData();

                String title = data.getStringExtra("JobTitle");
                String description = data.getStringExtra("JobDescription");
                String company = data.getStringExtra("JobCompany");
                String salary = data.getStringExtra("JobSalary");
                String location = data.getStringExtra("JobLocation");


                TextView jobView = new TextView(this);
                jobView.setText("Title: " + "\nDescription: " + description + "\nCompnay " + company + "\nSalary: " + salary + "\nLocation: " + location);
                jobView.setPadding(10, 10, 10, 10);
                jobView.setTextSize(16);

                jobListContainer.addView(jobView);

            }
        });







    }
}