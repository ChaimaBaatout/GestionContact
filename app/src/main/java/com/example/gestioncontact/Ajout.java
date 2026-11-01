package com.example.gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ajout extends AppCompatActivity {
EditText nom,prenom,num;
Button ajout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        nom=findViewById(R.id.ed_nom_ajout);
        prenom=findViewById(R.id.ed_prenom_ajout);
        num=findViewById(R.id.ed_num_ajout);
        ajout=findViewById(R.id.btn_ajout_ajout);

        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent myIntent = new Intent(Ajout.this, Affichage.class);
                    myIntent.putExtra("nom",nom.getText().toString());
                    myIntent.putExtra("prenom",prenom.getText().toString());
                    myIntent.putExtra("num",num.getText().toString());
                    startActivity(myIntent);


            }
        });





    }
}