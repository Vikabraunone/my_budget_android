package com.example.mybudget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.mybudget.models.Category;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity {
    ListView lv;
    ImageButton addButton;
    CategoryAdapter lvAdapter;
    ArrayList<Category> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        this.setTitle(getResources().getString(R.string.category_activity_label));

        lv = (ListView) findViewById(R.id.lv);
        addButton = (ImageButton) findViewById(R.id.addButton);

        models = new ArrayList<>();
        models.add(new Category(1, "Продукты"));
        models.add(new Category(2, "Транспорт"));
        models.add(new Category(3, "Образование"));
        models.add(new Category(4, "Одежда"));
        models.add(new Category(5, "Дом"));
        models.add(new Category(6, "Развлечения"));

        lvAdapter = new CategoryAdapter(this, models);
        lv.setAdapter(lvAdapter);

        addButton.setOnClickListener(view -> addCategory());
    }

    public void deleteCategory(Object model) {
        this.models.remove(model);
        this.lvAdapter.notifyDataSetChanged();
    }

    public void readCategory(Object model) {
        Intent intent = new Intent(getApplicationContext(), CategoryActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("model", (Serializable) model);
        bundle.putSerializable("operation", CRUD.READ);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void addCategory() {
        Intent intent = new Intent(getApplicationContext(), EditingActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("model", (Serializable) new Category(1, ""));
        bundle.putSerializable("operation", CRUD.UPDATE);
        intent.putExtras(bundle);
        startActivityForResult(intent, 200);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 200:
                    Bundle bundle = data.getExtras();
                    Category category = (Category) bundle.getSerializable("model");
                    models.add(category);
                    lvAdapter.notifyDataSetChanged();
                    break;
            }
        }
    }
}