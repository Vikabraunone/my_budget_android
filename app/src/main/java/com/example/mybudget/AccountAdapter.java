package com.example.mybudget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mybudget.models.Account;

import java.util.ArrayList;

public class AccountAdapter extends BaseAdapter {
    AccountsActivity context;
    LayoutInflater inflater;
    ArrayList<Account> objects;

    AccountAdapter(AccountsActivity context, ArrayList<Account> accounts) {
        this.context = context;
        objects = accounts;
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
            view = inflater.inflate(R.layout.item_list_view_account, viewGroup, false);
        }

        Account obj = (Account) getItem(i);
        TextView tvAccountName = view.findViewById(R.id.accountName);
        TextView tvAmount = view.findViewById(R.id.amount);
        ImageButton btnDelete = view.findViewById(R.id.deleteButton);

        tvAccountName.setText(obj.accountName);
        tvAmount.setText(obj.amount.toString());

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.deleteAccount(obj);
            }
        });

        tvAccountName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.editAccount(obj);
            }
        });

        return view;
    }
}
