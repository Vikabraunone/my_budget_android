package com.example.mybudget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mybudget.models.Account;
import com.example.mybudget.models.Category;
import com.example.mybudget.models.Subcategory;

import java.io.Serializable;

public class EditingActivity extends AppCompatActivity {
    Object model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editing);

        TextView tv = findViewById(R.id.tv);
        EditText et = findViewById(R.id.et);

        Button saveButton = findViewById(R.id.btnSave);
        Button cancelButton = findViewById(R.id.btnCancel);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        CRUD operation = (CRUD)bundle.getSerializable(KeyExtras.CRUD);
//
//
//        switch (operation) {
//            case CRUD.UPDATE:
//                Object obj = bundle.getSerializable("model");
//                if (obj instanceof Category) {
//                    model = (Category) obj;
//                    tv.setText("Название категории:");
//                    et.setText(((Category) obj).categoryName);
//                }
//                else if (obj instanceof Subcategory) {
//                    model = (Subcategory) obj;
//                    tv.setText("Название подкатегории:");
//                    et.setText(((Subcategory) obj).subcategoryName);
//                }
//                else if (obj instanceof Account) {
//                    model = (Account) obj;
//                    tv.setText("Название счета:");
//                    et.setText(((Account) obj).accountName);
//                }
//                break;
//        }

        saveButton.setOnClickListener(view -> {
            if (model instanceof Category) {
                ((Category)model).categoryName = et.getText().toString();
            }
            else if (model instanceof Subcategory) {
                ((Subcategory)model).subcategoryName = et.getText().toString();
            }
            else if (model instanceof Account) {
                ((Account)model).accountName = et.getText().toString();
            }
            Intent parent = new Intent();
            Bundle b = new Bundle();
            b.putSerializable("model", (Serializable) model);
            intent.putExtras(b);
            setResult(RESULT_OK, intent);
            finish();
        });

        cancelButton.setOnClickListener(view -> onBackPressed());
    }
}