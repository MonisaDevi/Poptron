package com.example.poptronproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.poptronproject.Model.EntireSharedPreferences;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText editEmail, editCreatePassword;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button loginBtn = findViewById(R.id.loginbtn);
        Button signUpBtn = findViewById(R.id.signupbtn);
        editEmail = findViewById(R.id.email);
        editCreatePassword = findViewById(R.id.password);
        if (EntireSharedPreferences.onceLoggedIn()) {
            loginBtn.setOnClickListener(v -> {
                //data from user
                String userEmail = editEmail.getText().toString();
                String userPassword = editCreatePassword.getText().toString();

                if (validEmail(EntireSharedPreferences.getEmail(), userEmail) && validPassword(EntireSharedPreferences.getPassword(), userPassword)) {
                    EntireSharedPreferences.doesNotLogin(false);
                    Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainBottomActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            signUpBtn.setOnClickListener(v -> {
                Intent activity = new Intent(LoginActivity.this, com.example.poptronproject.RegisterActivity.class);
                startActivity(activity);

            });
        } else {
            Intent intent = new Intent(LoginActivity.this, MainBottomActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public boolean validEmail(String sharedPreEmail, String enteredEmail) {

        if (TextUtils.isEmpty(enteredEmail)) {
            String string = "Enter the email";
            message(string);
            return false;
        } else if (sharedPreEmail.equals(enteredEmail)) {
            return true;
        } else {

            String string = "Invalid email";
            message(string);
            return false;
        }
    }

    public boolean validPassword(String sharedPrePass, String enteredPass) {

        if (TextUtils.isEmpty(enteredPass)) {
            String string = "Enter the password";
            message(string);
            return false;
        } else if (sharedPrePass.equals(enteredPass)) {
            return true;
        } else {

            String string = "Invalid password";
            message(string);
            return false;
        }
    }

    private void message(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }


}


