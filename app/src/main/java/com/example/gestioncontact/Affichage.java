package com.example.gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Affichage extends AppCompatActivity {
static ArrayList<Contact> contacts=new ArrayList<Contact>();
ListView lst;
EditText ed_rech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);
        ed_rech=findViewById(R.id.ed_recherche_aff);
        Intent x=this.getIntent();
        Bundle b=x.getExtras();
        if(b!=null){

            String nom=b.getString("nom");
            String prenom=b.getString("prenom");
            String num=b.getString("num");
            Contact c=new Contact(nom,prenom,num);
            contacts.add(c);
        }
        lst=findViewById(R.id.lv_affiche);

        ContactAdapter adapter=new ContactAdapter(Affichage.this,R.layout.view_contact,contacts);
        lst.setAdapter(adapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView num=view.findViewById(R.id.tv_num_contact);
                Toast toast = Toast.makeText(Affichage.this, num.getText().toString(), Toast.LENGTH_SHORT);
                toast.show();

                Contact c=contacts.get(i);
                ImageView call=view.findViewById(R.id.call);
                ImageView del=view.findViewById(R.id.del);
                ImageView edit=view.findViewById(R.id.edit);
                call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:" + num.getText().toString()));

                        startActivity(intent);
                    }
                });

                edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder alert = new AlertDialog.Builder(Affichage.this);
                        alert.setTitle("Delete entry");
                        //View a= LayoutInflater.from().inflate(R);
                        alert.setView(R.layout.dialogue);
                        alert.show();
                    }
                });

                ed_rech.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        
                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });



                del.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder alert = new AlertDialog.Builder(Affichage.this);
                        alert.setTitle("Delete entry");
                        alert.setMessage("Are you sure you want to delete?");

                        alert.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {


                            public void onClick(DialogInterface dialog, int which) {




                                contacts.remove(i);
                                adapter.notifyDataSetChanged();

                            }
                        });
                        alert.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // close dialog
                                dialog.cancel();
                            }
                        });
                        alert.show();


                        Toast toast = Toast.makeText(Affichage.this,"element supprimé", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

            }
        });



    }
}





/*
ArrayList<Contact> data2= new ArrayList<Contact>();


                CharSequence word=edrech.getText().toString();


                /*data2.addAll(data);*/

/*
                for (int i=0;i<Acceuil.data.size();i++){

                    if(Acceuil.data.get(i).getNom().contains(word)||Acceuil.data.get(i).getPrenom().contains(word))
                    {
                        data2.add(Acceuil.data.get(i));

                       // adapter.notifyDataSetChanged();


                    }

*/


