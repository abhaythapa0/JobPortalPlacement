package com.example.jobportalplacement;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddJobActivity extends AppCompatActivity {
    EditText jobTitle, jobDescription, jobCompany, jobSalary, jobLocation;
    Button submitJobButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_job);

        jobTitle = findViewById(R.id.jobTitle);
        jobDescription = findViewById(R.id.jobDescription);
        jobCompany = findViewById(R.id.jobCompany);
        jobSalary = findViewById(R.id.jobSalary);
        jobLocation = findViewById(R.id.jobLocation);

        submitJobButton = findViewById(R.id.submitJobButton);




        submitJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = jobTitle.getText().toString();
                String description = jobDescription.getText().toString();
                String company = jobCompany.getText().toString();
                String salary = jobSalary.getText().toString();
                String location = jobLocation.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("jobTitle", jobTitle.getText().toString());
                resultIntent.putExtra("jobDescription", jobDescription.getText().toString());
                resultIntent.putExtra("jobCompany", jobCompany.getText().toString());
                resultIntent.putExtra("jobSalary", jobSalary.getText().toString());
                resultIntent.putExtra("jobLocation", jobLocation.getText().toString());

               setResult(RESULT_OK, resultIntent);
               finish();

            }
        });

    }
    
}