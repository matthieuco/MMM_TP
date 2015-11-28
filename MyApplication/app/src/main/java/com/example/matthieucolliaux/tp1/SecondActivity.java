package com.example.matthieucolliaux.tp1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import static com.example.matthieucolliaux.tp1.R.layout.*;

/**
 * Created by matthieucolliaux on 04/10/15.
 */
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(secondactivity);
        //Bundle extras = getIntent().getExtras();
        User user = getIntent().getExtras().getParcelable("user");
       /*if (extras == null){
            return;
        }else {
           TextView champnom = (TextView) findViewById(R.id.nomtxt);
           String nom=extras.getString("nom");
           champnom .setText(nom);

           TextView champprenom = (TextView) findViewById(R.id.prenomtxt);
           String prenom=extras.getString("prenom");
           champprenom .setText(prenom);

           TextView champdate = (TextView) findViewById(R.id.datetxt);
           String date=extras.getString("date");
           champdate .setText(date);

           TextView champville = (TextView) findViewById(R.id.villetxt);
           String ville=extras.getString("ville");
           champville .setText(ville);
       }*/
        //parcelable
        TextView champnom = (TextView) findViewById(R.id.nomtxt);
        champnom .setText(user.getNom());

        TextView champprenom = (TextView) findViewById(R.id.prenomtxt);
        champprenom .setText(user.getPrenom());

        TextView champdate = (TextView) findViewById(R.id.datetxt);
        champdate .setText(user.getDate());

        TextView champville = (TextView) findViewById(R.id.villetxt);
        champville .setText(user.getVille());

    }

}
