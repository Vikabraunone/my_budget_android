package com.example.mybudget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.mybudget.models.Account;

import java.io.Serializable;

public class AccountActivity extends AppCompatActivity {
    EditText etAccountName;
    EditText etAmount;
    Button saveButton;
    Button cancelButton;

    Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        etAccountName = findViewById(R.id.etAccountName);
        etAmount = findViewById(R.id.etAccountSum);
        saveButton = findViewById(R.id.btnSave);
        cancelButton = findViewById(R.id.btnCancel);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        CRUD operation = (CRUD) bundle.getSerializable(KeyExtras.CRUD);

        if (operation == CRUD.UPDATE){
            account = (Account) bundle.getSerializable("model");
            etAccountName.setText(account.accountName);
            etAmount.setText(account.amount.toString());
        }
        else
            account = new Account();

        saveButton.setOnClickListener(view -> clickButtonSave());
        cancelButton.setOnClickListener(view -> onBackPressed());
    }

    private void clickButtonSave() {
        account.accountName = etAccountName.getText().toString();
        account.amount = Double.parseDouble(etAmount.getText().toString());

        Intent intent = new Intent();
        Bundle b = new Bundle();
        b.putSerializable(KeyExtras.model, (Serializable) account);
        intent.putExtras(b);
        setResult(RESULT_OK, intent);
        finish();
    }
}