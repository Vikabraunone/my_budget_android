package com.example.mybudget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText usernameEditText = (EditText) findViewById(R.id.etUsername);
        EditText emailEditText = (EditText) findViewById(R.id.etEmail);
        EditText passwordEditText = (EditText) findViewById(R.id.etPassword);

        Button btnRegister = (Button) findViewById(R.id.btnRegister);
        Button btnCancel = (Button) findViewById(R.id.btnCancel);

        btnRegister.setOnClickListener(view -> {
            Toast toast = Toast.makeText(getApplicationContext(),
                    getResources().getString(R.string.msgSuccessRegister), Toast.LENGTH_SHORT);
            toast.show();
        });

        btnCancel.setOnClickListener(view -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}