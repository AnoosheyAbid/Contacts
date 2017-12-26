package com.example.home.contacts;

/**
 * Created by home on 10/1/2017.
 */

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.R.attr.button;

public class CustomAdapter extends ArrayAdapter<Contacts> {

    Contacts c = new Contacts();
    ImageButton button;

    class ViewHolder {
        TextView nameview;
        TextView phoneview;
        TextView genderview;
    }

    public static final String TAG = "MTAG";

    public CustomAdapter(@NonNull Context context, List<Contacts> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View view = convertView;
        ViewHolder vh;
        c = getItem(position);


        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.custom_layout, parent, false);

            TextView nameview = (TextView) view.findViewById(R.id.name);
            TextView phoneview = (TextView) view.findViewById(R.id.phone);
            TextView genderview = (TextView) view.findViewById(R.id.gender);

            vh = new ViewHolder();
            vh.nameview = nameview;
            vh.phoneview = phoneview;
            vh.genderview = genderview;
            view.setTag(vh);

        }

        vh = (ViewHolder) view.getTag();

        vh.nameview.setText(c.getName());
        vh.phoneview.setText(c.getPhone());
        vh.genderview.setText(c.getGender());

        button = (ImageButton) view.findViewById(R.id.imageButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "Call Forwarding", Toast.LENGTH_SHORT).show();
                String number = c.getPhone().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                getContext().startActivity(callIntent);
            }


        });


        return view;
    }
}

