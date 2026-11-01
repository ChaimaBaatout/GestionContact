package com.example.gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText ed_mail,ed_pass;
private Button btn_val,btn_quit;
String mail="rania";
String pass="123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_mail=(EditText) findViewById(R.id.ed_mail_auth);
        ed_pass=(EditText) findViewById(R.id.ed_pass_auth);
        btn_val=(Button) findViewById(R.id.btn_val_auth);
        btn_quit=(Button) findViewById(R.id.btn_quit_auth);


        btn_val.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mail.equals(ed_mail.getText().toString())&&pass.equals(ed_pass.getText().toString())){
                    Intent myIntent = new Intent(MainActivity.this, Accueil.class);
                    myIntent.putExtra("username",ed_mail.getText().toString());
                    startActivity(myIntent);
                    //finish();
                }else{

                    Toast toast = Toast.makeText(MainActivity.this, "invalid", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });


        btn_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();
            }
        });

    }
}