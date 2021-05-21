package com.example.poptronproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.poptronproject.Model.EntireSharedPreferences;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {
    private TextInputEditText editName, editEmail, editPhone, editCreatePassword, editReEnterPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editName = findViewById(R.id.name);
        editEmail = findViewById(R.id.email);
        editPhone = findViewById(R.id.phone);
        editCreatePassword = findViewById(R.id.cpass);
        editReEnterPassword = findViewById(R.id.repass);
        Button btnDone = findViewById(R.id.donebtn);
        btnDone.setOnClickListener(v -> {
            String email = editEmail.getText().toString();
            String reenterPass = editReEnterPassword.getText().toString();
            String name = editName.getText().toString();
            String Phone = editPhone.getText().toString();
            String CreatePass = editCreatePassword.getText().toString();

            if (validateUsername() && validEmail() && validPhoneNumber(Phone) && validatePassword() && validReenterPass(reenterPass, CreatePass)) {
                EntireSharedPreferences.putUserName(name);
                EntireSharedPreferences.putMailId(email);
                EntireSharedPreferences.putPassword(reenterPass);
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private Boolean validateUsername() {
        String name = editName.getText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";

        if (name.isEmpty()) {
            editName.setError("Field cannot be empty");
            return false;
        } else if (name.length() >= 15) {
            editName.setError("Username too long");
            return false;
        } else if (!name.matches(noWhiteSpace)) {
            editName.setError("White Spaces are not allowed");
            return false;
        } else {
            editName.setError(null);
            return true;
        }
    }

    private Boolean validEmail() {
        String email = editEmail.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]";
        if (email.isEmpty()) {
            editEmail.setError("Field cannot be empty");
            return false;
        } else if (email.matches(emailPattern)) {
            editEmail.setError(null);
            return true;
        } else {
            editEmail.setError("Enter a valid email id");
            return false;
        }
    }

    public boolean validPhoneNumber(String phone) {
        boolean bool = true;

        if (TextUtils.isEmpty(phone)) {
            String phno = "phoneNumber";
            message(phno);
            return false;
        }
        return bool;
    }


    private Boolean validatePassword() {
        String password = editCreatePassword.getText().toString();
        String passwordVal = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

        if (password.isEmpty()) {
            editCreatePassword.setError("Field cannot be empty");
            return false;
        } else if (!password.matches(passwordVal)) {
            editCreatePassword.setError("Password is too weak");
            return false;
        } else {
            editCreatePassword.setError(null);
            return true;
        }
    }

    public boolean validReenterPass(String password, String confirmPassword) {
        boolean bool = false;

        if (confirmPassword.equals(password)) {
            return true;
        } else {
            message("reenter password");
            return false;
        }
    }

    public void message(String string) {
        Toast.makeText(this, " Enter valid " + string, Toast.LENGTH_LONG).show();
    }


    public void login(View view) {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);

    }

}


