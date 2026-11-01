package com.example.gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Accueil extends AppCompatActivity {
private TextView txt_title;
private Button ajout,affiche;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        txt_title=(TextView)findViewById(R.id.txt_title_acc);
        ajout=findViewById(R.id.btn_ajout_acc);
        affiche=findViewById(R.id.btn_affiche_acc);
        Intent x=this.getIntent();
        Bundle b=x.getExtras();
        String user=b.getString("username");
        txt_title.setText("Acceuil de "+user);



        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Accueil.this, Ajout.class);
                startActivity(myIntent);
            }
        });


        affiche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Accueil.this, Affichage.class);
                startActivity(i);
            }
        });
    }
}