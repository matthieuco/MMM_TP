package com.example.matthieucolliaux.tp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static com.example.matthieucolliaux.tp1.R.layout.activitytp2;

/**
 * Created by matthieucolliaux on 18/10/2015.
 */
public class activitytp2 extends AppCompatActivity {
    Button buttonnouveauclient;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activitytp2);
        buttonnouveauclient = (Button) findViewById(R.id.buttonnouveau);
        buttonnouveauclient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}

