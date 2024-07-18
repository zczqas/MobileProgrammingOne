package com.bca_sixth.mobileprogrammingone.unit_6;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bca_sixth.mobileprogrammingone.R;

public class CustomListItem extends ArrayAdapter<String> {
    int[] image;
    Activity ctx;
    String[] title;
    String[] description;

    public CustomListItem(Activity ctx, int[] image, String[] title, String[] description) {
        super(ctx, R.layout.unit_6_custom_list_item, title);

        this.ctx = ctx;
        this.image = image;
        this.title = title;
        this.description = description;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ListItemHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = ctx.getLayoutInflater();
            convertView = inflater.inflate(R.layout.unit_6_custom_list_item, parent, false);

            holder = new ListItemHolder();
            holder.image = convertView.findViewById(R.id.customListItemImage);
            holder.title = convertView.findViewById(R.id.customListItemTitle);
            holder.description = convertView.findViewById(R.id.customListItemDescription);

            convertView.setTag(holder);
        } else holder = (ListItemHolder) convertView.getTag();

        holder.image.setImageResource(image[position]);
        holder.title.setText(title[position]);
        holder.description.setText(description[position]);

        return convertView;
    }
}
