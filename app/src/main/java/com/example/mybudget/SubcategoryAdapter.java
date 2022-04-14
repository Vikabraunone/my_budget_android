package com.example.mybudget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mybudget.models.Subcategory;

import java.util.ArrayList;

public class SubcategoryAdapter extends BaseAdapter {
    CategoryActivity context;
    LayoutInflater inflater;
    ArrayList<Subcategory> objects;

    SubcategoryAdapter(CategoryActivity context, ArrayList<Subcategory> books) {
        this.context = context;
        objects = books;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int i) {
        return objects.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.item_list_view, viewGroup, false);
        }

        Subcategory object = (Subcategory) getItem(i);
        TextView tv = view.findViewById(R.id.name);
        ImageButton btnDelete = view.findViewById(R.id.deleteButton);

        tv.setText(object.subcategoryName);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.deleteSubcategory(object);
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.readSubcategory(object);
            }
        });

        return view;
    }
}
