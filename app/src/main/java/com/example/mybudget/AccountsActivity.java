package com.example.mybudget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.mybudget.models.Account;

import java.io.Serializable;
import java.util.ArrayList;

public class AccountsActivity extends AppCompatActivity {
    ListView lv;
    ImageButton addButton;
    AccountAdapter lvAdapter;
    ArrayList<Account> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);
        this.setTitle("Мои счета");

        lv = (ListView) findViewById(R.id.lv);
        addButton = (ImageButton) findViewById(R.id.addButton);

        models = new ArrayList<>();
        models.add(new Account(1, "Сбер мир", 10000.0));
        models.add(new Account(2, "Студенческая карта", 2000.50));

        lvAdapter = new AccountAdapter(this, models);
        lv.setAdapter(lvAdapter);
    }

    public void deleteAccount(Object model) {
        this.models.remove(model);
        this.lvAdapter.notifyDataSetChanged();
    }

    public void editAccount(Object model) {
        Intent intent = new Intent(this, AccountActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(KeyExtras.CRUD, CRUD.UPDATE);
        bundle.putSerializable(KeyExtras.model, (Serializable) model);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}