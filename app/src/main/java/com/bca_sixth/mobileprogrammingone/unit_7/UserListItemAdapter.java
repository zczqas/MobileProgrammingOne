package com.bca_sixth.mobileprogrammingone.unit_7;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bca_sixth.mobileprogrammingone.R;
import com.bca_sixth.mobileprogrammingone.unit_1.UserInfo;

import java.util.ArrayList;

public class UserListItemAdapter extends ArrayAdapter<String> {
    Activity ctx;
    ArrayList<Integer> id;
    ArrayList<String> name;
    ArrayList<String> address;

//    public UserListItemAdapter(Activity context, ArrayList<Integer> id, ArrayList<String> name, ArrayList<String> address) {
//        super(context, R.layout.unit_7_user_list_item, name);
//
//        this.id = id;
//        this.name = name;
//        this.ctx = context;
//        this.address = address;
//    }

    public UserListItemAdapter(Activity context, ArrayList<UserInfo> userInfoList) {
        super(context, R.layout.unit_7_user_list_item);

        this.ctx = context;
        this.id = new ArrayList<>();
        this.name = new ArrayList<>();
        this.address = new ArrayList<>();

        for (UserInfo userInfo : userInfoList) {
            this.id.add(userInfo.getId());
            this.name.add(userInfo.getName());
            this.address.add(userInfo.getAddress());
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View listItem, @NonNull ViewGroup parent) {
        UserListItemHolder holder;

        if (listItem == null) {
            LayoutInflater inflater = ctx.getLayoutInflater();

            // Inflate the layout
            listItem = inflater.inflate(R.layout.unit_7_user_list_item, parent, false);

            // Creating a new ViewHolder
            holder = new UserListItemHolder();

            holder.idView = listItem.findViewById(R.id.userListItemId);
            holder.nameView = listItem.findViewById(R.id.userListItemName);
            holder.addressView = listItem.findViewById(R.id.userListItemAddress);

            listItem.setTag(holder);
        } else holder = (UserListItemHolder) listItem.getTag();

        holder.nameView.setText(name.get(position));
        holder.addressView.setText(address.get(position));
        holder.idView.setText(String.valueOf(id.get(position)));

        return listItem;
    }
}
