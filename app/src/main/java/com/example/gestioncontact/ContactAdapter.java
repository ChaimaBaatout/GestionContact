package com.example.gestioncontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<Contact> {
    Context context;
    ArrayList<Contact> objects;
    int resource;
    public ContactAdapter( Context context, int resource,ArrayList<Contact> objects) {
        super(context, resource, objects);
        this.context=context;
        this.objects=objects;
        this.resource=resource;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(resource,parent,false);
        TextView nom=convertView.findViewById(R.id.tv_nom_contact);
        TextView prenom=convertView.findViewById(R.id.tv_prenom_contact);
        TextView num=convertView.findViewById(R.id.tv_num_contact);
        Contact contact=getItem(position);
        nom.setText(contact.nom);
        prenom.setText(contact.prenom);
        num.setText(contact.num);
        return convertView;
    }
}
