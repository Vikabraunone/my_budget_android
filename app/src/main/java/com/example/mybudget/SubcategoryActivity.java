package com.example.mybudget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mybudget.models.Subcategory;

import java.io.Serializable;

public class SubcategoryActivity extends AppCompatActivity {
    Subcategory obj;
    TextView tvName;
    ImageButton editButton;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategory);

        tvName = findViewById(R.id.et);
        editButton = findViewById(R.id.editButton);

        intent = getIntent();
        Bundle bundle = intent.getExtras();
        CRUD operation = (CRUD) bundle.getSerializable(KeyExtras.CRUD);
//        switch (operation){
//            case CRUD.READ:
//                obj = (Subcategory) bundle.getSerializable("model");
//                tvName.setText(obj.subcategoryName);
//                break;
//        }

        editButton.setOnClickListener(view -> editCategory());
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
//        Bundle b = new Bundle();
//        b.putSerializable("model", (Serializable) obj);
//        intent.putExtras(b);
//        setResult(RESULT_OK, intent);
//        finish();
    }

    public void editCategory() {
        Intent intent = new Intent(getApplicationContext(), EditingActivity.class);
        if (obj != null){
            Bundle bundle = new Bundle();
            bundle.putSerializable(KeyExtras.model, (Serializable) obj);
            bundle.putSerializable(KeyExtras.CRUD, CRUD.UPDATE);
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 100:
                    Bundle bundle = data.getExtras();
                    obj = (Subcategory) bundle.getSerializable("model");
                    tvName.setText(obj.subcategoryName);
                    break;
            }
        }
    }
}