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

public class UserListItemAdapter extends ArrayAdapter<UserInfo> {
    Activity ctx;
    ArrayList<UserInfo> userInfo;

    public UserListItemAdapter(Activity context, ArrayList<UserInfo> userInfoList) {
        super(context, R.layout.unit_7_user_list_item, userInfoList);

        this.ctx = context;
        this.userInfo = userInfoList;
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

        UserInfo currentData = userInfo.get(position);

        holder.nameView.setText(currentData.getName());
        holder.addressView.setText(currentData.getAddress());
        holder.idView.setText(String.valueOf(currentData.getId()));

        return listItem;
    }
}
