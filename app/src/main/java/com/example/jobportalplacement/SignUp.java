package com.example.jobportalplacement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    EditText username, email, password, confirmpassword;
    Button signup, loginlink;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);

        firebaseAuth=FirebaseAuth.getInstance();
        email=findViewById(R.id.txt_email);
        username=findViewById(R.id.txt_username);
        password=findViewById(R.id.txt_password);
        confirmpassword=findViewById(R.id.txt_cpassword);
        signup=findViewById(R.id.btn_signup);
        loginlink=findViewById(R.id.btn_loginlink);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email=email.getText().toString().trim();
                String Password=password.getText().toString().trim();
                String Username=username.getText().toString().trim();
                String ConfirmPassword=confirmpassword.getText().toString().trim();

                if (Email.isEmpty()){
                    Toast.makeText(SignUp.this, "Please Enter the Email", Toast.LENGTH_SHORT).show();
                }
                if (Password.isEmpty()){
                    Toast.makeText(SignUp.this, "Please Enter the Password", Toast.LENGTH_SHORT).show();
                }
                if (Username.isEmpty()){
                    Toast.makeText(SignUp.this, "Please Enter the Username", Toast.LENGTH_SHORT).show();
                }
                if (ConfirmPassword.isEmpty()){
                    Toast.makeText(SignUp.this, "Please Enter the Confirm Password", Toast.LENGTH_SHORT).show();
                }
                if (password.length()<6){
                    Toast.makeText(SignUp.this, "Password length must be greater than 6", Toast.LENGTH_SHORT).show();
                }
                if (ConfirmPassword.equals(Password)){
                    firebaseAuth.createUserWithEmailAndPassword(Email,Password).
                            addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(SignUp.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                                        Intent intent= new Intent(getApplicationContext(), Login.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else {
                                        Toast.makeText(SignUp.this, "Sign Up Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });

        loginlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

    }
}