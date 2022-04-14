package com.example.mybudget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mybudget.models.Category;
import com.example.mybudget.models.Subcategory;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {
    BroadcastReceiver br;
    Category category;

    ListView lv;
    TextView tvName;
    ImageButton addButton;
    ImageButton editButton;
    SubcategoryAdapter lvAdapter;
    ArrayList<Subcategory> objects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        tvName = findViewById(R.id.et);
        lv = (ListView) findViewById(R.id.lv);
        addButton = (ImageButton) findViewById(R.id.addButton);
        editButton = findViewById(R.id.editButton);

        objects = new ArrayList<>();
        objects.add(new Subcategory(1, 1, "Масло"));
        objects.add(new Subcategory(1, 1, "Яйца"));
        objects.add(new Subcategory(1, 1, "Хлеб"));
        objects.add(new Subcategory(1, 1, "Индейка"));

        lvAdapter = new SubcategoryAdapter(this, objects);
        lv.setAdapter(lvAdapter);
        addButton.setOnClickListener(view -> addSubcategory());
        editButton.setOnClickListener(view -> editCategory());
    }

    public void editCategory() {
        Intent intent = new Intent(getApplicationContext(), EditingActivity.class);
        if (category != null){
            Bundle bundle = new Bundle();
            bundle.putSerializable(KeyExtras.model, (Serializable) category);
            bundle.putSerializable(KeyExtras.CRUD, CRUD.UPDATE);
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, 100);
    }

    public void deleteSubcategory(Object model) {
        this.objects.remove(model);
        this.lvAdapter.notifyDataSetChanged();
    }

    public void readSubcategory(Object model) {
        Intent intent = new Intent(getApplicationContext(), SubcategoryActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(KeyExtras.CRUD, CRUD.READ);
        bundle.putSerializable(KeyExtras.model, (Serializable) model);
        intent.putExtras(bundle);
        startActivityForResult(intent, 600);
    }

    public void addSubcategory() {
        Intent intent = new Intent(getApplicationContext(), EditingActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(KeyExtras.CRUD, CRUD.UPDATE);
        bundle.putSerializable(KeyExtras.model, (Serializable) new Subcategory(1, 1,""));
        intent.putExtras(bundle);
        startActivityForResult(intent, 500);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // если пришло ОК
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            switch (requestCode) {
                case 100:
                    category = (Category) bundle.getSerializable(KeyExtras.model);
                    tvName.setText(category.categoryName);
                    break;
                case 500:
                    Subcategory subcategory = (Subcategory) bundle.getSerializable(KeyExtras.model);
                    objects.add(subcategory);
                    lvAdapter.notifyDataSetChanged();
                    break;
                case 600:
                    Subcategory sc = (Subcategory) bundle.getSerializable(KeyExtras.model);
                    for (int i=0; i < objects.size(); i++){
                        if (objects.get(i).id == sc.id) {
                            objects.get(i).subcategoryName = sc.subcategoryName;
                        }
                    }
                    lvAdapter.notifyDataSetChanged();
                    objects.add(sc);
                    break;
            }
        }
    }
}