package com.example.mybudget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mybudget.models.Category;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText emailEditText = (EditText) findViewById(R.id.etEmail);
        EditText passwordEditText = (EditText) findViewById(R.id.etPassword);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        TextView registerTextView = (TextView) findViewById(R.id.tvLoginRegister);

        btnLogin.setOnClickListener(view -> {
            Intent intent = new Intent(this, AccountsActivity.class);
            startActivity(intent);
            finish();
        });

        registerTextView.setOnClickListener(view -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}