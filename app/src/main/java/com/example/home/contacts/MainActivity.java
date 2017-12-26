package com.example.home.contacts;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageButton button;
    Toast toast;
    Contacts c = new Contacts();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //data
        final List<Contacts> contacts = new ArrayList<Contacts>();
        contacts.add(new Contacts("Abid Shah", "0300xxxxxxx", "Male"));
        contacts.add(new Contacts("Mamoon Abid", "0314mmmmmmm2", "Male"));
        contacts.add(new Contacts("Abid", "0300xxxxxxx", "Male"));

        for (int i = 3; i < 1000; i++) {
            contacts.add(new Contacts("ABC", "03XXXXXXXXX", "Female"));

        }

        //creating adapter
        ListView list = (ListView) findViewById(R.id.list);
        CustomAdapter adapter = new CustomAdapter(this, contacts);
        list.setAdapter(adapter);

          }}