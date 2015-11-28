package com.example.matthieucolliaux.tp1;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.matthieucolliaux.tp1.R.layout.*;

public class MainActivity extends AppCompatActivity {
    Button buttonvalider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        buttonvalider = (Button) findViewById(R.id.button);
        //affichage des champs du formulaire avec listener
        //affichagechampsjava();
        remplirchamps();
        //affichagechampsintent();
        affichagechampperson();
    }
    private void remplirchamps() {
        EditText nomedit = (EditText) findViewById(R.id.editText);
        nomedit.setText("Dylan");

        EditText prenomedit = (EditText) findViewById(R.id.editText2);
        prenomedit.setText("Bob");

        EditText dateedit = (EditText) findViewById(R.id.editText3);
        dateedit.setText("10/09/1960");

        EditText villeedit = (EditText) findViewById(R.id.editText4);
        villeedit.setText("Chicago");
    }
    private void affichagechampperson(){
        buttonvalider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), SecondActivity.class);
                EditText nomedit = (EditText) findViewById(R.id.editText);
                String nom = nomedit.getText().toString();

                EditText prenomedit = (EditText) findViewById(R.id.editText2);
                String prenom = prenomedit.getText().toString();

                EditText dateedit = (EditText) findViewById(R.id.editText3);
                String date = dateedit.getText().toString();

                EditText villeedit = (EditText) findViewById(R.id.editText4);
                String ville = villeedit.getText().toString();
                User user = new User(nom,prenom,date,ville);
                i.putExtra("user", (Parcelable) user);
                startActivity(i);
            }
        });
    }

    private void affichagechampsintent() {
        final Intent i = new Intent(this, SecondActivity.class);
        buttonvalider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nomedit = (EditText) findViewById(R.id.editText);
                String nom = nomedit.getText().toString();

                EditText prenomedit = (EditText) findViewById(R.id.editText2);
                String prenom = prenomedit.getText().toString();

                EditText dateedit = (EditText) findViewById(R.id.editText3);
                String date = dateedit.getText().toString();

                EditText villeedit = (EditText) findViewById(R.id.editText4);
                String ville = villeedit.getText().toString();

                i.putExtra("nom",nom);
                i.putExtra("prenom",prenom);
                i.putExtra("date",date);
                i.putExtra("ville",ville);
                startActivity(i);
            }
        });
    }
/*
    private void affichagechampsjava() {
        buttonvalider.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText nomedit = (EditText) findViewById(R.id.editText);
                Editable nom = nomedit.getText();

                EditText prenomedit = (EditText) findViewById(R.id.editText2);
                Editable prenom = prenomedit.getText();

                EditText dateedit = (EditText) findViewById(R.id.editText3);
                Editable date = dateedit.getText();

                EditText villeedit = (EditText) findViewById(R.id.editText4);
                Editable ville = villeedit.getText();

                Toast.makeText(getApplicationContext(), "nom :" + nom + " prenom :" + prenom + " date :" + date + " ville :" + ville,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       if(id == R.id.item1){
            removeChamps();
        }else if(id== R.id.item2) {
            addComposant();
        }else{
            opennavigateur();
        }

        return super.onOptionsItemSelected(item);
    }

    private void opennavigateur() {
        EditText villeedit = (EditText) findViewById(R.id.editText4);
        Editable ville = villeedit.getText();
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://fr.wikipedia.org/wiki/" + ville));

        startActivity(intent);
    }

    private void addComposant() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);
        TextView telephone = new TextView(this);
        telephone.setText("Téléphone :");
        telephone.setTextColor(Color.parseColor("#000000"));
        telephone.setPadding(0,50,0,0);
        EditText t1 = new EditText(this);
        layout.addView(telephone,10);
        layout.addView(t1,11);
    }

    private void removeChamps() {
        EditText nomedit = (EditText) findViewById(R.id.editText);
        nomedit.setText("");

        EditText prenomedit = (EditText) findViewById(R.id.editText2);
        prenomedit.setText("");

        EditText dateedit = (EditText) findViewById(R.id.editText3);
        dateedit.setText("");

        EditText villeedit = (EditText) findViewById(R.id.editText4);
        villeedit.setText("");
    }

/* affichage des champs du formulaire avec méthode appelé en xml
    public void affichageformulaire(View view){

        EditText nomedit = (EditText) findViewById(R.id.editText);
        Editable nom = nomedit.getText();

        EditText prenomedit = (EditText) findViewById(R.id.editText2);
        Editable prenom = prenomedit.getText();

        EditText dateedit = (EditText) findViewById(R.id.editText3);
        Editable date = dateedit.getText();

        EditText villeedit = (EditText) findViewById(R.id.editText4);
        Editable ville = villeedit.getText();

        Toast.makeText(getApplicationContext(), "nom :" +nom+ " prenom :" +prenom+ " date :" +date+ " ville :" +ville,
                Toast.LENGTH_SHORT).show();

    }*/
}
